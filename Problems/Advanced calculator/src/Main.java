/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int result = 0;
        int max = 0;
        int min ;

        switch (operator) {
            case "MAX":
                for (int i = 1; i < args.length; i++) {
                    if (Integer.parseInt(args[i]) >= max) {
                        max = Integer.parseInt(args[i]);
                    }
                }
                System.out.println(max);
                break;
            case "MIN":
                min = Integer.parseInt(args[1]);
                for (int i = 1; i < args.length; i++) {
                    if (Integer.parseInt(args[i]) < min) {
                        min = Integer.parseInt(args[i]);
                    }
                }
                System.out.println(min);
                break;
            case "SUM":
                for (int i = 1; i < args.length; i++) {
                    result += Integer.parseInt(args[i]);
                }
                System.out.println(result);
                break;
        }
    }
}
