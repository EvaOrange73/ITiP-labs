package Lab8;

import java.util.LinkedList;

public class URLPool {
    private LinkedList<URLDepthPair> unprocessed;
    private LinkedList<URLDepthPair> processed;
    private int waiting;
    private int maxDepth;

    URLPool(int maxDepth) {
        unprocessed = new LinkedList<>();
        processed = new LinkedList<>();
        waiting = 0;
        this.maxDepth = maxDepth;
    }

    public synchronized URLDepthPair getUrlDepthPair() {
        while (unprocessed.size() < 1) {
            try {
                waiting++;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        URLDepthPair current = unprocessed.get(0);
        processed.add(unprocessed.get(0));
        System.out.println(unprocessed.get(0));
        unprocessed.remove(0);
        return current;
    }

    public synchronized void putUrlDepthPair(URLDepthPair newPair) {
        if (newPair.getDepth() < maxDepth) {
            unprocessed.add(newPair);
            try {
                if (waiting > 0) waiting--;
                notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            processed.add(newPair);
        }
    }

    public synchronized void putUrlDepthPair(LinkedList<URLDepthPair> pairs) {
        if (!pairs.isEmpty())
            for (URLDepthPair pair : pairs) putUrlDepthPair(pair);
    }

    boolean isAllTreadsWaiting(int numberOfTreads) {
        return numberOfTreads == this.waiting;
    }
}
