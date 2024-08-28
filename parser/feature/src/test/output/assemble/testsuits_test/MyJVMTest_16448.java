public class MyJVMTest_16448 {

    static String s = "3p3!dfPQ;0";

    int m(String s) {
        switch(s) {
            case "one":
                return 1;
            case "two":
                return 2;
            default:
                return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16448().m(s));
    }
}
