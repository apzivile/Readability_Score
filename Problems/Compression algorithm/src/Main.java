import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int counter = 1;

        if (string.length() == 1) {
            System.out.println(string.charAt(0) + "" + counter);
        }
        for (int i = 0; i < string.length() - 1; i++) {

            if (string.charAt(i) == string.charAt(i + 1)) {
                counter++;

            } else {
                System.out.print(string.charAt(i) + "" + counter);
                counter = 1;
            }
            if (i == string.length() - 2 && counter >= 1) {
                System.out.print(string.charAt(i + 1) + "" + counter);
            }
        }
    }
}