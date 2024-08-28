public class MyJVMTest_17409 {

    static String s = ":b60\"U[[\\}";

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
        System.out.println(new MyJVMTest_17409().zeroHashes(s));
    }
}
