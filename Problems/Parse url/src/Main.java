import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String[] split = url.split("\\?");
        String[] strings = split[1].split("&");
        String password = null;
        for (String string : strings) {
            if (string.endsWith("=")) {
                System.out.print(string.replace("=", " : ") + "not found\n");
            } else {
                System.out.println(string.replace("=", " : "));
            }
            if (string.startsWith("pass")) {
                password = string.substring(5);

            }
        }
        if (password != null) {
            System.out.println("password : " + password);
        }
    }
}