package Utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.List;

/**
 * Created by 123 on 2017/12/02.
 *
 * @author 123
 *         模仿HTTPClient 客户端进行请求
 */

public class HttpClient {
    static CloseableHttpClient httpclient = null;
    static RequestConfig requestConfig = null;

    static {
        requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).build();
        httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
    }


    public static String doGet(String url) {


        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).build();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(url);
            httpget.addHeader("Cookie", "xxxxxxx");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            httpget.addHeader("Cache-Control", "no-cache");
            httpget.addHeader("Connection", "keep-alive");
            httpget.addHeader("Content-Type", "application/json; charset=UTF-8");
            httpget.addHeader("Referer", "http://www.zhihu.com/");
            httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 以utf-8形式读取
     */
    public static String doPost(String url, List<NameValuePair> formparams) {
        return doPost(url, formparams, "UTF-8");
    }

    public static String doPost(String url, List<NameValuePair> formparams, String charset) {
        RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.BEST_MATCH).build();
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        // 创建默认的httpClient实例.
        // CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Cookie", "xxxxxxx");
        httppost.addHeader("Accept-Encoding", "gzip, deflate");
        httppost.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        httppost.addHeader("Cache-Control", "no-cache");
        httppost.addHeader("Connection", "keep-alive");
        httppost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httppost.addHeader("Referer", "http://www.zhihu.com/");
        httppost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");


        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, charset);
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                // 打印响应状态
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    return EntityUtils.toString(entity);
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws IOException {
        String content = doGet("https://www.zhihu.com/explore");
        System.out.println(content);
       /* PrintWriter writer = new PrintWriter(new File("D:\\ideaFile\\Y2Projects\\Case\\src\\main\\java\\Utils\\resource\\a.text"));*/

        File file = new File("D:\\ideaFile\\Y2Projects\\Case\\src\\main\\java\\BasicsLore\\TutorialIO\\aa.text");

        PrintStream ps = new PrintStream(new FileOutputStream(file));
        String str = null;
        ps.println(content);

        InputStream is = new FileInputStream("D:\\ideaFile\\Y2Projects\\Case\\src\\main\\java\\Utils\\resource\\a.text");

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));


        while ((str = reader.readLine()) != null) {
            System.out.println(str);
        }

    }
}
