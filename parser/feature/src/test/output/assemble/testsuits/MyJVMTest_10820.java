public class MyJVMTest_10820 {

    static int i = 0;

    static int j = 0;

    int expect(int i, int j) {
        if (i != j) {
            throw new RuntimeException("Expected " + i + ", got " + j);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10820().expect(i, j);
    }
}
