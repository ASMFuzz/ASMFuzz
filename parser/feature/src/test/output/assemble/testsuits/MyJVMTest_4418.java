public class MyJVMTest_4418 {

    static int value = 0;

    void up() {
        ++value;
        notify();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4418().up();
    }
}
