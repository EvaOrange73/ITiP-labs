package Lab8;

import java.io.IOException;
import java.util.LinkedList;

public class App {
    private int maxDepth;
    private int maxNumberOfThread;
    private URLDepthPair statrUrl;
    private UserInterface UI;
    private LinkedList<URLDepthPair> unprocessed;
    private LinkedList<URLDepthPair> processed;
    private URLPool pool;

    App() {
        this.UI = new UserInterface();
        this.statrUrl = new URLDepthPair();
        this.maxDepth = 0;
        this.maxNumberOfThread = 0;
        this.unprocessed = new LinkedList<>();
        this.processed = new LinkedList<>();

    }

    private void start_test(){
        this.statrUrl = new URLDepthPair("http://htmlbook.ru/html/!doctype");
        this.maxDepth = 3;
        this.pool = new URLPool(maxDepth);
        this.maxNumberOfThread = 5;
        this.pool.putUrlDepthPair(this.statrUrl);
    }
    private void start(){
        this.statrUrl = new URLDepthPair(UI.getStartUrt());
        this.maxDepth = UI.getMaxDepth();
        this.pool = new URLPool(maxDepth);
        this.maxNumberOfThread = UI.getNumberOfThreads();
        this.pool.putUrlDepthPair(this.statrUrl);
    }

    private void scanner() throws InterruptedException {
        for (int i = 0; i < this.maxNumberOfThread; i++){
            CrawlerTask newTread = new CrawlerTask(this.pool);
            newTread.start();
        }
        while (!this.pool.isAllTreadsWaiting(this.maxNumberOfThread)){
            Thread.sleep(10);
        }
        System.exit(0);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        App app = new App();
        app.start_test();
        app.scanner();
    }
}
