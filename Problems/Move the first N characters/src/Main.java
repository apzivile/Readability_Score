import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int number = scanner.nextInt();

        if (number > word.length()) {
            System.out.println(word);
        } else {
            String firstPart = word.substring(0, number);
            String lastPart = word.substring(number);
            System.out.println(lastPart + firstPart);
        }

    }
}