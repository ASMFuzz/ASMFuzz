public class MyJVMTest_6938 {

    static String s = "ihT!_Ej1bm";

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
        System.out.println(new MyJVMTest_6938().m(s));
    }
}
