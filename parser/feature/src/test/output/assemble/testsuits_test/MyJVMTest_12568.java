public class MyJVMTest_12568 {

    static String x = "LF9FL9(TVT";

    static String y = "N9Do1yjxj%";

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
        System.out.println(new MyJVMTest_12568().compare(x, y));
    }
}
