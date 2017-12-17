package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.SocketHandler;

public class demo implements Runnable{
	private CountDownLatch countDown;
    public demo(CountDownLatch countDown){
        this.countDown = countDown;
    }
    @Override
    public void run() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lock?useUnicode=true&characterEncoding=UTF-8",
                    "root", "123456");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            conn.setAutoCommit(false);
            //不加锁的情况
            PreparedStatement ps =conn.prepareStatement("select * from mycount where id=1");
            //加锁的情况
           // PreparedStatement ps =conn.prepareStatement("select count from mycount where id =1 for update");
            //1：from where for select
            ResultSet rs=ps.executeQuery();
            int count = 0;
            while(rs.next()){
                count= rs.getInt("count");
            }
            count++;
            ps =conn.prepareStatement("update mycount set count=? where id =1");
            ps.setInt(1, count);
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        //表示一次任务完成
        countDown.countDown();
    }
}
