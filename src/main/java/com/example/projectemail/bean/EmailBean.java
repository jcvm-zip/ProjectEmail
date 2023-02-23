package com.example.projectemail.bean;

import com.example.projectemail.dto.EmailLayout;
import com.example.projectemail.model.Email;
import com.example.projectemail.service.EmailService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("com/example/projectemail/bean")
@RequestScoped
public class EmailBean implements Serializable {

    private static final long serialVersionUID = 6197677053835209045L;

    private static final String DESTINATARIO = "jeffesoncarvalho10@gmail.com";
    private static final String ASSUNTO = "TESTE DO PROJETO";

    @Inject
    private EmailService emailService;
    public String enviarEmail(){

        emailService.enviar(montarEmail());

        return null;
    }

    public Email montarEmail() {

        EmailLayout layout = new EmailLayout();

        return layout.montarEmailAdmin("jeffesoncarvalho10@gmail.com", "Teste do projeto");
    }



}
