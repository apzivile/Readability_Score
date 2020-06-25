class Problem {

    public static void main(String[] args) {
        int result;
        if ("+".equals(args[0])) {
            result = Integer.parseInt(args[1]) + Integer.parseInt(args[2]);
            System.out.println(result);
        } else if ("-".equals(args[0])) {
            result = Integer.parseInt(args[1]) - Integer.parseInt(args[2]);
            System.out.println(result);
        } else if ("*".equals(args[0])) {
            result = Integer.parseInt(args[1]) * Integer.parseInt(args[2]);
            System.out.println(result);
        } else {
            System.out.println("Unknown operator");
        }
    }
}