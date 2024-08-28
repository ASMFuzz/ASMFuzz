public class MyJVMTest_1198 {

    static boolean localizedMessageCalled = false;

    String getLocalizedMessage() {
        localizedMessageCalled = true;
        return new String("FOOBAR");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1198().getLocalizedMessage());
    }
}
