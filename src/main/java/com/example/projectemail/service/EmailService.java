package com.example.projectemail.service;

import com.example.projectemail.model.Email;
import com.example.projectemail.util.LogUtil;
import jakarta.ejb.Stateless;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Stateless
public class EmailService extends Thread {

    private List<Email> emails;

    public static final String HEADER_CONTEXT = "text/html; charset=utf-8";

    public void enviar(Email email) {
        emails = new ArrayList<>();
        emails.add(email);
    }
    public void enviar(List<Email> emails) {
        this.emails = emails;
    }

    private EmailService coppy() {
        EmailService emailService = new EmailService();
        emailService.emails = emails;
        return emailService;
    }


    @Override
    public void run() {
        Properties properties = new Properties();

        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host", System.getProperty("email-project.mail.smtp.host"));
        properties.put("mail.smtp.port", System.getProperty("email-project.mail.smtp.port"));

        Session session = Session.getInstance(properties);
        session.setDebug(false);

        for (Email email:emails) {

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(System.getProperty("email.project.mail.from")));

                if (email.getDestinatario().contains("/")) {
                    List<InternetAddress> emailsLocal = new ArrayList<>();

                    for (String e: email.getDestinatario().split("/")) {
                        emailsLocal.add(new InternetAddress(e));
                    }
                    message.addRecipients(Message.RecipientType.TO, emailsLocal.toArray(new InternetAddress[0]));
                } else {
                    InternetAddress para = new InternetAddress(email.getDestinatario());
                    message.addRecipient(Message.RecipientType.TO, para);
                }

                message.setSubject(email.getAssunto());
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setHeader("Content-type", HEADER_CONTEXT );
                textPart.setContent(email.getTexto(), HEADER_CONTEXT);
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(textPart);
                message.setContent(mp);
                Transport.send(message);


            }catch (MessagingException e) {
                LogUtil.getLogger(EmailService.class).error("Erro ao enviar e-mail: " + e.getMessage());
            }
        }
    }
}
