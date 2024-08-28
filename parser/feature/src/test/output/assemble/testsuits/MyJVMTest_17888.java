public class MyJVMTest_17888 {

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = -228550502;

    String returnThree() {
        return "3";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17888().returnThree());
    }
}
