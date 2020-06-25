import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> sequences = new ArrayList<>();
        while (scanner.hasNext()) {
            String sequence = scanner.next();
            if ("0".equals(sequence)) {
                break;
            }
            sequences.add(sequence);
        }
        for (String sequence : sequences) {
            try {
                multiplyInput(sequence);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + sequence);
            }
        }
    }

    public static void multiplyInput(String sequences) {
        int number = Integer.parseInt(String.valueOf(sequences));
        System.out.println(number * 10);
    }
}
