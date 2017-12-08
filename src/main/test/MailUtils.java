
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.*;
import java.security.GeneralSecurityException;
import java.util.*;
import javax.activation.*;

public class MailUtils{
    public static void main(String[] args) throws MessagingException, MessagingException, GeneralSecurityException {

        //0.5，props和authenticator参数
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");

        //QQ邮箱的SSL加密。
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        //authenticator参数，登录自己的邮箱帐号密码，
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                /**
                 * 注意，QQ邮箱的规则是如果不是由腾讯的网页或者客户端打开登录的话，在其他任何地方
                 *登录邮箱，密码必须使用授权码，授权码下面会讲解，vlyvawibbsribgee
                 *xxxxxxx:自己的QQ邮箱登录帐号，也就是qq号
                 *yyyyyyy:密码，使用授权码登录，而不能使用原始的QQ密码
                 */
                return new PasswordAuthentication("qq邮箱帐号","授权码");
            }
        };
        //1、连接
        /**
         * props
         *         连接配置信息，邮件服务器的地址，是否进行权限验证
         * authenticator
         *         权限验证，也就是帐号密码验证
         * 所以需要先配置这两个参数
         */
        Session session = Session.getDefaultInstance(props, authenticator);

        //2、发送的内容对象Mesage
        Message message = new MimeMessage(session);
        //2.1、发件人是谁
        message.setFrom(new InternetAddress("529075990@qq.com"));
        // 2.2  , to:收件人 ; cc:抄送 ; bcc :暗送.
        /**
         * 收件人是谁？
         *         第一个参数：
         *             RecipientType.TO    代表收件人
         *             RecipientType.CC    抄送
         *             RecipientType.BCC    暗送
         *         比如A要给B发邮件，但是A觉得有必要给要让C也看看其内容，就在给B发邮件时，
         *         将邮件内容抄送给C，那么C也能看到其内容了，但是B也能知道A给C抄送过该封邮件
         *         而如果是暗送(密送)给C的话，那么B就不知道A给C发送过该封邮件。
         *     第二个参数
         *         收件人的地址，或者是一个Address[]，用来装抄送或者暗送人的名单。或者用来群发。
         */
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("2778269182@qq.com"));
        // 2.3 主题（标题）
        message.setSubject("hello");
        // 2.4 正文
        String str = "苦水润喉";
        message.setContent(str, "text/html;charset=UTF-8");
        //3、发送
        Transport.send(message);
    }

}