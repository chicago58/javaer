package com.wolf.longpolling;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-19 13:35
 **/
@WebServlet(urlPatterns = "/long-polling")
public class Server extends HttpServlet {

    private final Random random = new Random();

    private final AtomicLong sequence = new AtomicLong();

    private final AtomicLong value = new AtomicLong();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final long currentSequence = sequence.incrementAndGet();

        System.out.println("第" + (currentSequence) + "次 long polling");

        int sleepSeconds = random.nextInt(100);
        System.out.println(currentSequence + " wait " + sleepSeconds + " second");

        try {
            TimeUnit.SECONDS.sleep(sleepSeconds);
        } catch (Exception e) {

        }

        PrintWriter out = resp.getWriter();
        long result = value.getAndIncrement();
        out.write(Long.toString(result));
        out.flush();
    }
}
