class Problem {
    public static void main(String[] args) {
        boolean isPresent = false;
        for (int i = 0; i < args.length; i++) {
            if ("test".equals(args[i])) {
                System.out.println(i);
                isPresent = true;
                break;
            }
        }
        if (!isPresent) {
            System.out.println("-1");
        }
    }
}