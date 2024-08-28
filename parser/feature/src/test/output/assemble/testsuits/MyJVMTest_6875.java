public class MyJVMTest_6875 {

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

    boolean isReceiverNull() {
        return this == null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6875().isReceiverNull());
    }
}
