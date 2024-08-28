public class MyJVMTest_3247 {

    static String x = "H+Nb~.bKFB";

    static String y = "MP/I<;,\"<z";

    int compare(String x, String y) {
        if (x == null && y == null)
            return 0;
        if (x == null && y != null)
            return 1;
        if (x != null && y == null)
            return -1;
        return x.compareTo(y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3247().compare(x, y));
    }
}
