public class MyJVMTest_16215 {

    static int i3 = 0;

    void throwException3() throws Exception {
        if (i3 < 2) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16215().throwException3();
    }
}
