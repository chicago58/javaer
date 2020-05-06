package com.wolf.longpolling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-03-19 11:18
 **/
public class Client {

    protected static final String URL = "http://localhost:8080/long-polling";

    protected static final String ASYNC_URL = "";

    private final AtomicLong sequence = new AtomicLong();

    protected void poll() {
        // 循环执行，保证每次long polling结束，再次发起long polling
        while (!Thread.interrupted()) {
            doPoll();
        }
    }

    protected void doPoll() {
        System.out.println("第" + (sequence.incrementAndGet()) + "次 long polling");

        long startMillis = System.currentTimeMillis();

        HttpURLConnection conn = null;
        try {
            URL url = new URL(URL);
            conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(50000);
            conn.setConnectTimeout(3000);
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept-Charset", "application/json;charset=UTF-8");
            conn.connect();

            if (200 == conn.getResponseCode()) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    StringBuilder result = new StringBuilder(256);
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    System.out.println("结果：" + result);
                } finally {
                    if (reader != null) {
                        reader.close();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("request failed.");
        } finally {
            long elapsed = (System.currentTimeMillis() - startMillis) / 1000;
            System.out.println("connection close elapse " + elapsed + "s");

            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();

        //发起long polling
        client.poll();
        System.in.read();
    }
}
