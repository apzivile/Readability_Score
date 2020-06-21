import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticket = scanner.nextLine();
        int beginningSum = 0;
        int endingSum = 0;

        for (int i = 0; i < ticket.length(); i++) {
            int sum = Integer.parseInt(String.valueOf(ticket.charAt(i)));
            if (i < 3) {
                beginningSum += sum;
            } else {
                endingSum += sum;
            }
        }
        if (beginningSum == endingSum) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}