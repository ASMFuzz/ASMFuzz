public class MyJVMTest_18201 {

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    String returnTwo() {
        return "2";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18201().returnTwo());
    }
}
