public class MyJVMTest_7849 {

    static String s = "I\"1*K%uj{t";

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7849().zeroHashes(s));
    }
}
