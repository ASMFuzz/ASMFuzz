public class MyJVMTest_10398 {

    static boolean localizedMessageCalled = false;

    String getLocalizedMessage() {
        localizedMessageCalled = true;
        return new String("FOOBAR");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10398().getLocalizedMessage());
    }
}
