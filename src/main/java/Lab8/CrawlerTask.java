package Lab8;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class CrawlerTask extends Thread {
    private URLPool pool;

    CrawlerTask(URLPool pool){
        this.pool = pool;
    }

    @Override
    public void run(){
        while (true) {
            URLDepthPair urlDepthPair = pool.getUrlDepthPair();
            LinkedList<URLDepthPair> sites = new LinkedList<>();
            Socket socket = null;
            try {
                socket = new Socket(urlDepthPair.getHost(), 80);
                socket.setSoTimeout(10000);

                OutputStream outputStream = socket.getOutputStream();
                PrintStream printStream = new PrintStream(outputStream, true);
                printStream.println("GET " + urlDepthPair.getUrl() + " HTTP/1.1");
                printStream.println("Host: " + urlDepthPair.getHost() + ":80");
                printStream.println("Connection: close");
                printStream.println();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line = in.readLine();
                while (line != null) {
                    String[] tags = line.split(">");
                    for (String tag : tags) {
                        URLDepthPair newPair = new URLDepthPair(
                                tag,
                                urlDepthPair.getHost(),
                                urlDepthPair.getDepth() + 1);
                        if (!newPair.getUrl().isEmpty()) {
                            sites.add(newPair);
                        }
                        if (sites.size() > 10) break;
                    }
                    line = in.readLine();
                }
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pool.putUrlDepthPair(sites);
        }
    }
}
