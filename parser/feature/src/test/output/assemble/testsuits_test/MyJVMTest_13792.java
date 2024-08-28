public class MyJVMTest_13792 {

    static int i = 0;

    int method(int i) {
        boolean a;
        if ((i < 7) ? a = true : false) {
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13792().method(i);
    }
}
