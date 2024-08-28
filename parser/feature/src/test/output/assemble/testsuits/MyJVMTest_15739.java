public class MyJVMTest_15739 {

    static int size = 3;

    int badFunc(int size) {
        try {
            for (int i = 0; i < 1; (new byte[size - i])[0] = 0, i++) {
            }
        } catch (Exception e) {
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15739().badFunc(size);
    }
}
