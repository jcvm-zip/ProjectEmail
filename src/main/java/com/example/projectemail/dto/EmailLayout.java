package com.example.projectemail.dto;
import com.example.projectemail.model.Email;

public class EmailLayout {

    private static final String QUEBRA_DE_LINHA_DUPLA = "<br><br>";
    private static final String QUEBRA_DE_LINHA_UNICA = "<br>";

    public Email montarEmailAdmin(String destinatario, String assunto) {

        StringBuilder texto = new StringBuilder();

        texto
                .append("A/C administrador")
                .append(QUEBRA_DE_LINHA_DUPLA);
        texto
                .append("Solicito alteração de senha do sistema!")
                .append(QUEBRA_DE_LINHA_DUPLA);

        gerarAssinatura(texto);

        gerarRodape(texto);

        return new Email(destinatario, assunto, texto.toString());
    }public Email montarEmailSecretario(String destinatario, String assunto) {

        StringBuilder texto = new StringBuilder();

        texto
                .append("A/C Secretário")
                .append(QUEBRA_DE_LINHA_DUPLA);
        texto
                .append("Mensagem para Secretaria")
                .append(QUEBRA_DE_LINHA_DUPLA);

        gerarAssinatura(texto);

        gerarRodape(texto);

        return new Email(destinatario, assunto, texto.toString());
    }

    private String gerarAssinatura(StringBuilder texto) {
        return texto
                .append("Att: ")
                .append(QUEBRA_DE_LINHA_UNICA)
                .append("Operador de caixa")
                .append(QUEBRA_DE_LINHA_DUPLA).toString();

    }

    private String gerarRodape(StringBuilder texto){
        return texto.append("Email automático, Favor não responder a esse e-mail!").toString();
    }


}
