public class MyJVMTest_6410 {

    static int mValue = 0;

    void go() {
        mValue = 2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6410().go();
    }
}
