public class MyJVMTest_14208 {

    static String RESULT_1 = "1";

    static int arg = 0;

    String method1() {
        return RESULT_1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14208().method1());
    }
}
