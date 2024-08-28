public class MyJVMTest_13292 {

    static String message = "?4eFB<ur,G";

    static int state = 5;

    static int size = 2093872875;

    void doThis() {
        for (int i = 0; i < size; i++) {
            System.out.println(" .... Message " + message);
            state++;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13292().doThis();
    }
}
