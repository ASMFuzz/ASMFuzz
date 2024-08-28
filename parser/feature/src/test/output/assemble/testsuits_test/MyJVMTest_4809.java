public class MyJVMTest_4809 {

    static String RESULT_1 = "1";

    static int arg = -1601626013;

    String method1() {
        return RESULT_1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4809().method1());
    }
}
