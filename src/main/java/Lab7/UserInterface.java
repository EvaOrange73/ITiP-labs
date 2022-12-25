package Lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UserInterface {
    public String getStartUrt() {
        System.out.println("Введите url");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://www.nytimes.com/";
    }

    public int getMaxDepth() {
        System.out.println("Введите глубину поиска");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void printPairs(LinkedList<URLDepthPair> list) {
        for (URLDepthPair pair : list) {
            System.out.println(pair.toString());
        }
    }
}
