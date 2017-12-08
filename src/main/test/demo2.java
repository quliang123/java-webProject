import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
public class demo2 {

	public static void main(String[] args) throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");

        props.put("mail.smtp.port", "587");
        props.put("mail.user", "529075990@qq.com");
        props.put("mail.password", "rvobjexjktwqbhcg");

        Authenticator authenticator = new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(mailSession);
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        InternetAddress to = new InternetAddress("quliang1234567@126.com");
        message.setRecipient(RecipientType.TO, to);

        message.setSubject("哈哈哈");

        message.setContent("https://www.baidu.com", "text/html;charset=UTF-8");

        Transport.send(message);
        System.out.println();
	}

}
