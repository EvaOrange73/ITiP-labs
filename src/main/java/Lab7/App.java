package Lab7;

import java.io.IOException;
import java.util.LinkedList;

public class App {
    private int maxDepth;
    private URLDepthPair statrUrl;
    private UserInterface UI;
    private Crawler crawler;
    private LinkedList<URLDepthPair> unprocessed;
    private LinkedList<URLDepthPair> processed;

    App() {
        this.UI = new UserInterface();
        this.statrUrl = new URLDepthPair();
        this.maxDepth = 0;
        this.crawler = new Crawler();
        this.unprocessed = new LinkedList<>();
        this.processed = new LinkedList<>();

    }

    void start() {
        this.statrUrl = new URLDepthPair(UI.getStartUrt());
        this.maxDepth = UI.getMaxDepth();
    }

    void scanner() {
        unprocessed = crawler.getSites(statrUrl);
        while (unprocessed.size() > 0) {
            URLDepthPair current = unprocessed.get(0);
            if (current.getDepth() < this.maxDepth) unprocessed.addAll(crawler.getSites(unprocessed.get(0)));
            processed.add(unprocessed.get(0));
            unprocessed.remove(0);
        }
    }

    void end() {
        this.UI.printPairs(processed);
    }


    public static void main(String[] args) throws IOException {
        App app = new App();
        app.start();
        app.scanner();
        app.end();
    }
}
