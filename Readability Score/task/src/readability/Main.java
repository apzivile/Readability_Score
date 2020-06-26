package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/in.txt");
        Scanner scanner = new Scanner(file);
        //sentences
        String sentence = scanner.nextLine().replaceAll("\u00a0", " ").toLowerCase();
        String[] smt = sentence.split("\\s+");
        String[] sentences = sentence.split("(?<=!|\\.|\\?)");
        //String[] smt = sentence.split()
        //count words
        List<String> wordList;
        List<String> charList = null;
        List<String> lettersList;
        int words = 0;
        int characters = 0;
        int syllables = 0;
        int polysyllables = 0;
        int vowels = 0;
        int consonants = 0;
        int charactersPer100Words = 0;
        int sentencesPer100Words = 0;
        int averageCharacters = 0;
        int averageSentences = 0;
        int numberOfTimes=1;
        int charSum=0;
        int sentenceSum=0;
        int numOfTimes=1;
        boolean endsWithE = false;
        boolean isVowel = false;
        boolean smth = false;
        int count1 = 0;
        int count2 = 0;
        //  System.out.println(Arrays.toString(smt));
        //  System.out.println(smt.length);

        for (String s : sentences) {

            String[] tempWords = s.split("\\s");
            wordList = new ArrayList<>(Arrays.asList(tempWords));
            wordList.removeAll(Arrays.asList("", null));
            words += wordList.size();
            //  while (count<=100){
            if (count1<=100) {
                sentencesPer100Words++;
                count1 += wordList.size();
            }

            //   }
            //  System.out.println(wordList);
            //  System.out.println(wordList.size());

            // while (count <= 100) {
            //      sentencesPer100Words += tempWords.length;
            //      count++;
            //  }
            //   System.out.println("hell = " + sentencesPer100Words);
            //  System.out.println(Arrays.toString(tempWords));
            //  count characters
            for (String string : wordList) {
                String[] tempChar = string.split("");
                charList = new ArrayList<>(Arrays.asList(tempChar));
                characters += charList.size();
                // System.out.println(charList.size());

                if (count2 <= 100) {
                    charactersPer100Words += charList.size();
                    count2++;
                    if (count2 == 100) {
                        charSum+=charactersPer100Words;
                        count2=0;
                        numberOfTimes++;
                    }
                }

                //  averageSentences = sentencesPer100Words


                charList.remove(".");
                charList.remove("!");
                charList.remove("?");
                charList.remove(",");
                //   for (int i = 0; i < charList.size() - 1; i++) {
                if ("e".equals(charList.get(charList.size() - 1))) {
                    charList.remove("e");
                }
            }
            //  System.out.println(charList.get(100));
            for (int i = 0; i < charList.size() - 1; i++) {
                if (charList.get(i).equals("a")
                        || charList.get(i).equals("e")
                        || charList.get(i).equals("i")
                        || charList.get(i).equals("o")
                        || charList.get(i).equals("u")
                        || charList.get(i).equals("y")) {
                    isVowel = true;
                    vowels++;
                } else {
                    isVowel = false;
                }
                if (isVowel && (charList.get(i + 1).equals("a")
                        || charList.get(i + 1).equals("e")
                        || charList.get(i + 1).equals("i")
                        || charList.get(i + 1).equals("o")
                        || charList.get(i + 1).equals("u")
                        || charList.get(i + 1).equals("y"))) {
                    vowels--;
                }
            }
            if (vowels == 0) {
                vowels = 1;
            }
            if (vowels > 2) {
                polysyllables++;
            }
            if (vowels > 0) {
                syllables += vowels;
                vowels = 0;
            }

        }


        //double scoreARI = (4.71 * characters / words + 0.5 * words / sentences.length - 21.43);
        //double scoreFK = (0.39 * words / sentences.length + 11.8 * syllables / words - 15.59);
        //   BigDecimal bigDecimalScore = BigDecimal.valueOf(scoreARI);
        //  bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
        // Math.ceil(scoreARI);
        System.out.println(charactersPer100Words);
        System.out.println(averageCharacters);
        System.out.println(sentencesPer100Words);
        System.out.println(averageSentences);
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences.length);
        System.out.println("Characters: " + characters);
        System.out.println("Syllabus: " + syllables);
        //scoreLevel(scoreARI);
        System.out.println("Polysyllables: " + polysyllables);

        averageCharacters = charSum/numberOfTimes;
        averageSentences = sentenceSum/numOfTimes;

        System.out.println("sentec :" + averageCharacters);
        System.out.println("sentecass :" + averageSentences);

        calculateScore(characters, words, sentences.length, syllables, polysyllables, averageCharacters);
        scanner.close();
    }

    public static void calculateScore(int characters, int words, double sentences, int syllables, int polysyllables, int l) {
        Scanner scanner = new Scanner(System.in);
        double score = 0;
        double averageAge = 0;
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String scoreType = scanner.nextLine();
        System.out.println();
        switch (scoreType) {
            case "ARI":
                score = (4.71 * characters / words + 0.5 * words / sentences - 21.43);
                BigDecimal bigDecimalScore = BigDecimal.valueOf(score);
                bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
                System.out.print("Automated Readability Index: ");
                scoreLevel(score, bigDecimalScore);
                break;
            case "FK":
                score = (0.39 * words / sentences + 11.8 * syllables / words - 15.59);
                bigDecimalScore = BigDecimal.valueOf(score);
                bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
                System.out.print("Flesch–Kincaid readability tests: ");
                scoreLevel(score, bigDecimalScore);
                break;
            case "SMOG":
                score = (1.043 * Math.sqrt(polysyllables * 30 / sentences) + 3.1291);
                bigDecimalScore = BigDecimal.valueOf(score);
                bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
                System.out.print("Simple Measure of Gobbledygook: ");
                scoreLevel(score, bigDecimalScore);
                break;
            case "CL":
                //score = (0.0588 * l - 0.296 * s - 15.8);
                bigDecimalScore = BigDecimal.valueOf(score);
                bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
                System.out.print("Coleman–Liau index: ");
                scoreLevel(score, bigDecimalScore);
                break;
            case "all":
                double scoreARI = (4.71 * characters / words + 0.5 * words / sentences - 21.43);
                bigDecimalScore = BigDecimal.valueOf(scoreARI);
                bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
                System.out.print("Automated Readability Index: ");
                scoreLevel(scoreARI, bigDecimalScore);
                double scoreFK = (0.39 * words / sentences + 11.8 * syllables / words - 15.59);
                bigDecimalScore = BigDecimal.valueOf(scoreFK);
                bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
                System.out.print("Flesch–Kincaid readability tests: ");
                scoreLevel(scoreFK, bigDecimalScore);
                double scoreSMOG = (1.043 * Math.sqrt(polysyllables * 30 / sentences) + 3.1291);
                bigDecimalScore = BigDecimal.valueOf(scoreSMOG);
                bigDecimalScore = bigDecimalScore.setScale(2, RoundingMode.DOWN);
                System.out.print("Simple Measure of Gobbledygook: ");
                scoreLevel(scoreSMOG, bigDecimalScore);
                break;
        }
        System.out.println("This text should be understood in average by " + "year olds.");
    }


    public static void scoreLevel(double score, BigDecimal bigScore) {
        switch ((int) Math.floor(score)) {
            case 1:
                System.out.println(bigScore + " (about 6 year olds).");
                break;
            case 2:
                System.out.println(bigScore + " (about 7 year olds).");
                break;
            case 3:
                System.out.println(bigScore + " (about 9 year olds).");
                break;
            case 4:
                System.out.println(bigScore + " (about 10 year olds).");
                break;
            case 5:
                System.out.println(bigScore + " (about 11 year olds).");
                break;
            case 6:
                System.out.println(bigScore + " (about 12 year olds).");
                break;
            case 7:
                System.out.println(bigScore + " (about 13 year olds).");
                break;
            case 8:
                System.out.println(bigScore + " (about 14 year olds).");
                break;
            case 9:
                System.out.println(bigScore + " (about 15 year olds).");
                break;
            case 10:
                System.out.println(bigScore + " (about 16 year olds).");
                break;
            case 11:
                System.out.println(bigScore + " (about 17 year olds).");
                break;
            case 12:
                System.out.println(bigScore + " (about 18 year olds).");
                break;
            case 13:
                System.out.println(bigScore + " (about 19 year olds).");
                break;
            case 14:
                System.out.println(bigScore + " (about 24+ year olds).");
                break;
        }
    }
}