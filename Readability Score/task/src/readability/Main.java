package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        //sentences
        String sentence = scanner.nextLine().replaceAll("\u00a0", " ");
        String[] sentences = sentence.split("(?<=!|\\.|\\?)");
        //count words
        List<String> wordList;
        List<String> charList;
        int words = 0;
        int characters = 0;
        for (String s : sentences) {
            String[] tempWords = s.split("\\s");
            wordList = new ArrayList<>(Arrays.asList(tempWords));
            wordList.removeAll(Arrays.asList("", null));
            words += wordList.size();
            //  count characters
            for (String string : wordList) {
                String[] tempChar = string.split("");
                charList = new ArrayList<>(Arrays.asList(tempChar));
                characters += charList.size();
            }
        }
        double score = (4.71 * characters / words + 0.5 * words / sentences.length - 21.43);
        BigDecimal bigDecimalScore = BigDecimal.valueOf(score);
        bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences.length);
        System.out.println("Characters: " + characters);
        System.out.println("The score is: " + bigDecimalScore);
        scoreLevel(score);
        scanner.close();
    }

    public static void scoreLevel(double score) {
        switch ((int) score + 1) {
            case 1:
                System.out.println("This text should be understood by 5-6 year olds.");
                break;
            case 2:
                System.out.println("This text should be understood by 6-7 year olds.");
                break;
            case 3:
                System.out.println("This text should be understood by 7-9 year olds.");
                break;
            case 4:
                System.out.println("This text should be understood by 9-10 year olds.");
                break;
            case 5:
                System.out.println("This text should be understood by 10-11 year olds.");
                break;
            case 6:
                System.out.println("This text should be understood by 11-12 year olds.");
                break;
            case 7:
                System.out.println("This text should be understood by 12-13 year olds.");
                break;
            case 8:
                System.out.println("This text should be understood by 13-14 year olds.");
                break;
            case 9:
                System.out.println("This text should be understood by 14-15 year olds.");
                break;
            case 10:
                System.out.println("This text should be understood by 15-16 year olds.");
                break;
            case 11:
                System.out.println("This text should be understood by 16-17 year olds.");
                break;
            case 12:
                System.out.println("This text should be understood by 17-18 year olds.");
                break;
            case 13:
                System.out.println("This text should be understood by 18-24 year olds.");
                break;
            case 14:
                System.out.println("This text should be understood by 24+ year olds.");
                break;
        }
    }
}
