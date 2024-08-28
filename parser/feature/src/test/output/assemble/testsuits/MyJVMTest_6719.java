public class MyJVMTest_6719 {

    static int i3 = 0;

    void throwException3() throws Exception {
        if (i3 < 2) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6719().throwException3();
    }
}
