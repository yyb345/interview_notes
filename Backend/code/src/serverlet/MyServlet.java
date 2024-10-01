package serverlet;

import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationSupport;

import java.io.IOException;

public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        final Continuation continuation = ContinuationSupport.getContinuation(request);

        if (continuation.isInitial()) {
            // 初始请求处理
            // 进行一些必要的操作

            // 挂起请求
            continuation.suspend();

            // 模拟异步操作，延迟2秒钟
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(2000);

                    // 唤醒请求处理
                    continuation.resume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        } else {
            // 唤醒后的处理
            try {
                response.getWriter().println("Request processing resumed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
