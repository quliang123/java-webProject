import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
public class demo1 {
	 public static void main(String [] args) throws GeneralSecurityException 
	    {
	        // �ռ��˵�������
	        String to = "530422781@qq.com";

	        // �����˵�������
	        String from = "2236632046@qq.com";

	        // ָ�������ʼ�������Ϊ smtp.qq.com
	        String host = "smtp.qq.com";  //QQ �ʼ�������

	        // ��ȡϵͳ����
	        Properties properties = System.getProperties();

	        // �����ʼ�������
	        properties.setProperty("mail.smtp.host", host);

	        properties.put("mail.smtp.auth", "true");
	        MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
	        // ��ȡĬ��session����
	        Session session = Session.getDefaultInstance(properties,new Authenticator(){
	            public PasswordAuthentication getPasswordAuthentication()
	            {
	                return new PasswordAuthentication("2236632046@qq.com", "sjsadxrxtpdjebda"); //�������ʼ��û���������
	            }
	        });

	        try{
	            // ����Ĭ�ϵ� MimeMessage ����
	            MimeMessage message = new MimeMessage(session);

	            // Set From: ͷ��ͷ�ֶ�
	            message.setFrom(new InternetAddress(from));

	            // Set To: ͷ��ͷ�ֶ�
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: ͷ��ͷ�ֶ�
	            message.setSubject("This is the Subject Line!");

	            // ������Ϣ��
	            message.setText("This is actual message");

	            // ������Ϣ
	            Transport.send(message);
	            System.out.println("Sent message successfully....from runoob.com");
	        }catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	    }
}
