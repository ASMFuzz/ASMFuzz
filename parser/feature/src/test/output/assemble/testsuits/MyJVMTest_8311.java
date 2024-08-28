public class MyJVMTest_8311 {

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 7;

    String returnThree() {
        return "3";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8311().returnThree());
    }
}
