package com.example.commerciale.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendHtmlEmail(List<String> to, String subject, String body) {
        // Crée un objet MimeMessage
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            // Utilise MimeMessageHelper pour simplifier la configuration
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Convertit la liste de destinataires en un tableau de chaînes
            String[] recipients = to.toArray(new String[to.size()]);

            // Définit le sujet et le corps du message
            helper.setSubject(subject);
            helper.setTo(recipients);

            // Définit le corps du message au format HTML
            helper.setText(body, true);

            // Utilise le JavaMailSender pour envoyer le message
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace(); // Gérer l'exception selon vos besoins
        }
    }
}
