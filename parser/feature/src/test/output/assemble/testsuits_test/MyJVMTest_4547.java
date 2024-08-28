public class MyJVMTest_4547 {

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    String returnOne() {
        return "1";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4547().returnOne());
    }
}
