package service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    public static void sendEmail(String recipientEmail, String subject, String messageBody) {
        // Thiết lập thông tin máy chủ
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", 587);

        //xác thực tài khoản email
        Session session = Session.getInstance(p, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {// nhập tài khoản email của bạn vào để có thể chạy
                return new PasswordAuthentication("nguyentrongtin1804204@gmail.com", "ejre xvsj wpsw gokw");
            }
        });

        try {
            // Tạo đối tượng mes
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("nguyentrongtin1804204@gmail.com"));// nhập tài khoản email của bạn vào để có  thể chạy
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(messageBody);

            // Gửi email
            Transport.send(message);

            System.out.println("Email gửi thành công!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
