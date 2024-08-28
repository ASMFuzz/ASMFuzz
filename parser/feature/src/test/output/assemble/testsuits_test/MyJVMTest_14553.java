public class MyJVMTest_14553 {

    static int i = 0;

    int m(int i) {
        throw new AssertionError();
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14553().m(i);
    }
}
