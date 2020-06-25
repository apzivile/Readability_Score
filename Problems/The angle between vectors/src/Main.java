import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstA = scanner.nextDouble();
        double firstB = scanner.nextDouble();
        double secondA = scanner.nextDouble();
        double secondB = scanner.nextDouble();

        double lengthA = Math.sqrt((firstA * firstA) + (firstB * firstB));
        double lengthB = Math.sqrt((secondA * secondA) + (secondB * secondB));
        double dotProduct = (firstA * secondA) + (firstB * secondB);
        double angle = Math.toDegrees(Math.acos(dotProduct / (lengthA * lengthB)));

        System.out.println(Math.floor(angle));
    }
}