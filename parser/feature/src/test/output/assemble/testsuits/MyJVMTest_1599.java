public class MyJVMTest_1599 {

    static int i = 0;

    static int j = 0;

    int expect(int i, int j) {
        if (i != j) {
            throw new RuntimeException("Expected " + i + ", got " + j);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1599().expect(i, j);
    }
}
