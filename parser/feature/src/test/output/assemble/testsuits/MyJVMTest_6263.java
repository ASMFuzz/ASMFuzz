public class MyJVMTest_6263 {

    static int size = 7;

    int badFunc(int size) {
        try {
            for (int i = 0; i < 1; (new byte[size - i])[0] = 0, i++) {
            }
        } catch (Exception e) {
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6263().badFunc(size);
    }
}
