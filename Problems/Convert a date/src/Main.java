
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        String[] dateArray = date.split("-");
        if (Integer.parseInt(dateArray[1]) > 12 || Integer.parseInt(dateArray[2]) > 31) {
            System.out.println("Invalid input");
        } else {
            System.out.println(dateArray[1] + "/" + dateArray[2] + "/" + dateArray[0]);
        }
    }
}