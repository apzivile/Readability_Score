package readability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine().replace(",", "").replaceAll("\u00a0", " ");
        String[] sentences = sentence.split("!|\\.|\\?");
        List<String> tempp;
        float average;
        float sum = 0;
        for (String s : sentences) {
            String[] temp = s.split("\\s");
            tempp = new ArrayList<>(Arrays.asList(temp));
            tempp.removeAll(Arrays.asList("", null));
            sum += tempp.size();
        }
        average = sum / sentences.length;
        if (average > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }

    }
}
