package com.example.projectemail.model;

import java.util.Objects;

public class Email {

    private String destinatario;
    private String assunto;
    private String texto;

    public Email(String destinatario, String assunto, String texto) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.texto = texto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(destinatario, email.destinatario) && Objects.equals(assunto, email.assunto) && Objects.equals(texto, email.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinatario, assunto, texto);
    }

    @Override
    public String toString() {
        return "Email{" +
                "destinatario='" + destinatario + '\'' +
                ", assunto='" + assunto + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
