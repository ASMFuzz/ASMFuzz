public class MyJVMTest_10869 {

    static String why = "OOv\\E_b{2U";

    static String failure = "6kx5Eg#w |";

    static String what = "-IA^A:7FwH";

    String fail(String why) {
        System.out.println("FAIL: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10869().fail(why);
    }
}
