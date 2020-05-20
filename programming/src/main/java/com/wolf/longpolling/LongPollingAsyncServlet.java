package com.wolf.longpolling;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description 开启异步Servlet
 * @Author wangqikang
 * @CreatedAt 2020-03-19 13:51
 **/
@WebServlet(urlPatterns = "/long-polling-async", asyncSupported = true)
public class LongPollingAsyncServlet extends HttpServlet {

    private Random random = new Random();

    private final AtomicLong sequence = new AtomicLong();

    private final AtomicLong value = new AtomicLong();

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 50000L,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long currentSequence = sequence.incrementAndGet();
        System.out.println("第" + (currentSequence) + "次 long polling async");

        //设置request异步处理
        AsyncContext asyncContext = req.startAsync();

        asyncContext.setTimeout(51000);
        asyncContext.addListener(new AsyncListener() {
            public void onComplete(AsyncEvent asyncEvent) throws IOException {

            }

            public void onTimeout(AsyncEvent asyncEvent) throws IOException {

            }

            public void onError(AsyncEvent asyncEvent) throws IOException {

            }

            public void onStartAsync(AsyncEvent asyncEvent) throws IOException {

            }
        });

        executor.submit(new HandlePollingTask(currentSequence, asyncContext));
    }

    class HandlePollingTask implements Runnable {
        private AsyncContext asyncContext;

        private long sequence;

        public HandlePollingTask(long sequence, AsyncContext asyncContext) {
            this.sequence = sequence;
            this.asyncContext = asyncContext;
        }

        public void run() {
            try {
                PrintWriter out = asyncContext.getResponse().getWriter();
                int sleepSeconds = random.nextInt();

                System.out.println(sequence + " wait " + sleepSeconds + " second");

                try {
                    TimeUnit.SECONDS.sleep(sleepSeconds);
                } catch (Exception e) {

                }

                long result = value.getAndIncrement();
                out.write(Long.toString(result));
            } catch (Exception e) {
                System.out.println(sequence + "handle polling failed");
            } finally {
                asyncContext.complete();
            }
        }
    }
}
