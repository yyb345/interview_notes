package leetcodeinfo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LeetCodeLogin {
    public static void main(String[] args) {
        //String loginUrl = "https://leetcode.com/accounts/login";
        String url = "https://leetcode.com/api/submissions/?offset=0&limit=20&lastkey=";


        String username = "43695929@qq.com"; // Replace with your username
        String password = "yyb921205"; // Replace with your password

        try {
            // Step 1: Log in to LeetCode


            Connection.Response loginResponse =  Jsoup.connect(url)
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36")
                    .header("csrftoken","mQkLaWHRqp6XYY3YNZW3msq2FhHBB2D4kfohmXzIwsApaJIMODLqG2BPL7wMStkr")
                    .header("Cookie","csrftoken=mQkLaWHRqp6XYY3YNZW3msq2FhHBB2D4kfohmXzIwsApaJIMODLqG2BPL7wMStkr")
                    .header("referer","https://leetcode.com/submissions/")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .method(Connection.Method.POST)
                    .data("csrfmiddlewaretoken","mQkLaWHRqp6XYY3YNZW3msq2FhHBB2D4kfohmXzIwsApaJIMODLqG2BPL7wMStkr")
                    .execute();


            Document document = Jsoup.connect(url)
                    .cookies(loginResponse.cookies())
                    .get();

            // Print the scraped HTML
            System.out.println(document.html());
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            String cookie =
//                    "__stripe_mid=dd16013d-c39f-4557-b29c-359789c265d046adcf; gr_user_id=1e048540-3351-4b9f-93d7-f746b85698c2; 87b5a3c3f1a55520_gr_last_sent_cs1=yangyibo; __gads=ID=d4ac2f602f2a02d3:T=1725780422:RT=1725780422:S=ALNI_MbL5d0g5dgLapjc32qQ0HwjHkbHpg; __gpi=UID=00000ef41f4d575d:T=1725780422:RT=1725780422:S=ALNI_MZaYxYYzzTdtz2KXXyXxBmjyXXO7w; __eoi=ID=3735f7bd9cc88ad2:T=1725780422:RT=1725780422:S=AA-AfjZI_321RLwLfdPtjA8iWDzB; FCNEC=%5B%5B%22AKsRol_Y8fpsFls-hMldqR_IJ1tuAuckN2EzMpgo-MMJUzyhxHFMVIoxSD_SBndRYcyphcrxeXA8VPDLkDRvZXlSlqC8ZuU-Eu9MPFtNt3EvLQs_I7ud79gDOPhTdEkIXhFGYlf6SCfrpRV7MfpnSSMQE2eO9s1HtA%3D%3D%22%5D%5D; _gid=GA1.2.2083981574.1728283697; ip_check=(false, \"2400:1c00:486:6e25:71da:c983:b349:6f44\"); cf_clearance=0Hgq92ZWcchEygdENc4wNv850o3oAsnZfLrIKCLTsQY-1728294317-1.2.1.1-3mveGGZ0Pg6QFsy0anrxUJpnWZSgZujg2.rVVvht5poIs_86LuoCP99qqSLzFFSExoxTprFmpElpantl6FMruEFZ6hZgKyLndtd2CYAZ3vMf_yE_XEbxe8UuRrwYiu6RSVbIsF2BVav4R9T6vo72hqm_s6EX3qvgrkjox.xbBA9DRwJR_1xS9cn33BEJ9B2BeAKqgr2NeTzSeerYPS70Ywzl1fUodODdjs6Bg.x10D1OoBYQ7dZ1E3YLH_EbDDwS.Ts4Wsxd7FuBHq34Lm_zrg3nNgQmuDP3oOSxYgjEKzR22IVJacY71O.4bY4o9ictxdnYn4qJv5ZtIVrlrg1VtLatVYzjKZOnnqeRznKKwr6_lruzuKiMkORaR9huKpcou8J6pcohQxf1M1WoRoPrwLXYRd.WDn3JOgY3enaT7_S6ffNL5R7jbNjWbqU0F94R; csrftoken=mQkLaWHRqp6XYY3YNZW3msq2FhHBB2D4kfohmXzIwsApaJIMODLqG2BPL7wMStkr; messages=.eJyLjlaKj88qzs-Lz00tLk5MT1XSMdAxMtVRiswvVchILEtVKM5Mz0tNUcgvLdFTitXBpTy4NDkZKJJWmpNTCdOSmaeQWKxQmZiXXpmZlI9PNy0siwUA36tKjw:1sxkIq:0QNuGy4cfoZccCyv4SrbcEggPKY2oOX392-SwjNsSAY; LEETCODE_SESSION=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfYXV0aF91c2VyX2lkIjoiMjU1Mzk1IiwiX2F1dGhfdXNlcl9iYWNrZW5kIjoiYWxsYXV0aC5hY2NvdW50LmF1dGhfYmFja2VuZHMuQXV0aGVudGljYXRpb25CYWNrZW5kIiwiX2F1dGhfdXNlcl9oYXNoIjoiOGQ4NjFjZmRhZjUxMTg2OGIwNDk0OWNhOTNjY2JkYzg2NDBlODQ0NTkyOTY4OTI5MWVjODhiMDBkMTU2MGY3MyIsImlkIjoyNTUzOTUsImVtYWlsIjoiNDM2OTU5MjlAcXEuY29tIiwidXNlcm5hbWUiOiJ5YW5neWlibyIsInVzZXJfc2x1ZyI6Inlhbmd5aWJvIiwiYXZhdGFyIjoiaHR0cHM6Ly9hc3NldHMubGVldGNvZGUuY29tL3VzZXJzL3lhbmd5aWJvL2F2YXRhcl8xNzI3MzY5MjI2LnBuZyIsInJlZnJlc2hlZF9hdCI6MTcyODI5NDMyMCwiaXAiOiIyNDAwOjFjMDA6NDg5Ojc2ZTo1YzU5OjY3ZDA6ZmE5ODplMTliIiwiaWRlbnRpdHkiOiIwOTk5M2FiODY4ZjQ3MGNmMjRlMjZmYTRmOTQzOWQ5ZSIsImRldmljZV93aXRoX2lwIjpbImRiZjliYWQ4NDg3ZTY5NTYxNjNjMjg5NzhiZmY2MjM1IiwiMjQwMDoxYzAwOjQ4OTo3NmU6NWM1OTo2N2QwOmZhOTg6ZTE5YiJdLCJzZXNzaW9uX2lkIjo3NDc5MTI3NiwiX3Nlc3Npb25fZXhwaXJ5IjoxMjA5NjAwfQ.lm09VA_EBfQgvIGlCb7o6BEnUGJKwklTCWj3pYjiGXs; 87b5a3c3f1a55520_gr_session_id=4d238331-bfda-4977-9435-39b07b9d0b37; 87b5a3c3f1a55520_gr_last_sent_sid_with_cs1=4d238331-bfda-4977-9435-39b07b9d0b37; 87b5a3c3f1a55520_gr_session_id_sent_vst=4d238331-bfda-4977-9435-39b07b9d0b37; INGRESSCOOKIE=cee48c664b42dfdf14d7f215aeff6946|8e0876c7c1464cc0ac96bc2edceabd27; _ga=GA1.1.1948505836.1725684123; _ga_CDRWKZTDEX=GS1.1.1728299955.102.1.1728302202.39.0.0; _dd_s=rum=0&expire=1728305041329; 87b5a3c3f1a55520_gr_cs1=yangyibo";
//
//            // 创建 URL 对象
//            URL obj = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//            // 设置请求方法
//            con.setRequestMethod("GET");
//
//            // 设置 Cookie
//            con.setRequestProperty("Cookie", cookie);
//
//            // 获取响应
//            int responseCode = con.getResponseCode();
//            System.out.println("Response Code: " + responseCode);
//
//            // 读取响应内容
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // 打印响应内容
//            System.out.println(response.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
