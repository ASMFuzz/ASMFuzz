public class MyJVMTest_8609 {

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 7;

    String returnTwo() {
        return "2";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8609().returnTwo());
    }
}
