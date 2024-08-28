public class MyJVMTest_15256 {

    int zeroHashes(String s) {
        int result = Integer.MAX_VALUE;
        switch(s) {
            case "":
                return 0;
            case "\u0000":
                result = 1;
                break;
            case "\u0000\u0000":
                return 2;
            case "\u0000\u0000\u0000":
                result = 3;
                break;
            case "\u0000\u0000\u0000\u0000":
                return 4;
            case "\u0000\u0000\u0000\u0000\u0000":
                result = 5;
                break;
            case "\u0000\u0000\u0000\u0000\u0000\u0000":
                return 6;
            default:
                result = -1;
        }
        return result;
    }

    int testPileup() {
        int failures = 0;
        String zero = "";
        for (int i = 0; i <= 6; i++, zero += "\u0000") {
            int result = zeroHashes(zero);
            if (result != i) {
                failures++;
                System.err.printf("For string \"%s\" unexpectedly got %d instead of %d%n.", zero, result, i);
            }
        }
        if (zeroHashes("foo") != -1) {
            failures++;
            System.err.println("Failed to get -1 for input string.");
        }
        return failures;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15256().testPileup());
    }
}
