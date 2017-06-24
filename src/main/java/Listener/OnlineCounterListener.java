package Listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by 123 on 2017/06/22.
 */
public class OnlineCounterListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        synchronized (OnlineCounterListener.class) {
            System.out.println("创建成功  ");
            HttpSessionEvent sessionEvent = (HttpSessionEvent) httpSessionEvent.getSession();
            String sessionid = sessionEvent.getSession().getId();
           // sessionEvent.getSession().invalidate();
            OnlineCounter.raise();
        }

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        synchronized (OnlineCounterListener.class) {
            System.out.println("销毁成功  ");
            OnlineCounter.reduce();
        }
    }
}
