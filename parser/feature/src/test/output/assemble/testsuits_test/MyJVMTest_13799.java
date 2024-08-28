public class MyJVMTest_13799 {

    static int value = 0;

    void up() {
        ++value;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13799().up();
    }
}
