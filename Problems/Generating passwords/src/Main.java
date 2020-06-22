import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int uppercase  = scanner.nextInt();
        int lowercase   = scanner.nextInt();
        int digits   = scanner.nextInt();
        int nSymbols  = scanner.nextInt();

        int difference = nSymbols - (uppercase + lowercase + digits);

        StringBuilder password = new StringBuilder("");

        for (int i = 0; i < uppercase; i++) {
            if (i % 2 == 0) {
                password.append("A");
            } else {
                password.append("B");
            }
        }
        for (int i = 0; i < lowercase; i++) {
            if (i % 2 == 0) {
                password.append("a");
            } else {
                password.append("b");
            }
        }
        for (int i = 0; i < digits; i++) {
            if (i % 2 == 0) {
                password.append("1");
            } else {
                password.append("2");
            }
        }
        for (int i = 0; i < difference; i++) {
            if (i % 2 == 0) {
                password.append("+");
            } else {
                password.append("#");
            }
        }

        System.out.println(password);
    }
}