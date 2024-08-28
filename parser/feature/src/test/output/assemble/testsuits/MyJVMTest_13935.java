public class MyJVMTest_13935 {

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 3;

    String returnOne() {
        return "1";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13935().returnOne());
    }
}
