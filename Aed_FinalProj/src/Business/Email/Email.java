/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Email;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;


/**
 *
 * @author Komal
 */
public class Email {

    public static void sendEmail(String to, String subject, String msg, String from, String userName, String password, String selectedPath) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Session session;
        session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);

            BodyPart part1 = new MimeBodyPart();
            part1.setText(msg);

            BodyPart part2 = new MimeBodyPart();
            DataSource attachment = new FileDataSource(selectedPath);
            part2.setDataHandler(new DataHandler(attachment));
            part2.setFileName(selectedPath);

            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(part1);
            multiPart.addBodyPart(part2);

            message.setContent(multiPart);
            
            Transport.send(message);
            System.out.println("Message with attachment sent successfully....");
            
        } catch (MessagingException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Error!!");
            printStackTrace(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
