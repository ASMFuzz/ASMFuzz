public class MyJVMTest_2340 {

    static String x = "K{o+8BqKUQ";

    static String y = "%5_Or~Bh94";

    int compare(String x, String y) {
        return (x == null ? -1 : y == null ? 1 : x.compareTo(y));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2340().compare(x, y));
    }
}
