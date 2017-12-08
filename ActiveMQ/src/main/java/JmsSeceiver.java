import org.apache.activemq.spring.ActiveMQConnectionFactory;

import javax.jms.*;

import static javafx.scene.input.DataFormat.URL;

/**
 * Created by 123 on 2017/11/26.
 */
public class JmsReceiver {
    public static void main(String[] args) throws Exception

    {
        ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://192.168.1.120:61616");
        Connection connection = null;
        try {
            connection = cf.createConnection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        try {
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        final Session session;
        try {
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        Destination destination = session.createQueue(:"my-queue" );
        MessageConsumer consumer = null;
        try {
            consumer = session.createConsumer(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        int i = 0;
        while (i < 3) {
            i++;
            TextMessage message = null;
            try {
                message = (TextMessage) consumer.receive();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                session.commit();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("收到消息:" + message.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                session.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }