public class MyJVMTest_1793 {

    static int a = 3;

    static int i1 = 0;

    static int i2 = 1;

    static int i3 = 4;

    void resetValues() {
        i1 = 0;
        i2 = 0;
        i3 = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1793().resetValues();
    }
}
