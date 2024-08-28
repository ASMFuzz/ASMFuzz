public class MyJVMTest_9088 {

    static String message = "K7kEHWfdr<";

    static int state = 1224318301;

    static int size = 0;

    void doThis() {
        for (int i = 0; i < size; i++) {
            System.out.println(" .... Message " + message);
            state++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9088().doThis();
    }
}
