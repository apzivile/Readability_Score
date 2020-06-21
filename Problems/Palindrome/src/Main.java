import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        boolean isPalindrome = false;
        int backwards = word.length() - 1;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(backwards)) {
                backwards--;
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}