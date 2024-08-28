public class MyJVMTest_11017 {

    static int a = 1;

    static int i1 = 8;

    static int i2 = -251502045;

    static int i3 = 4;

    void resetValues() {
        i1 = 0;
        i2 = 0;
        i3 = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11017().resetValues();
    }
}
