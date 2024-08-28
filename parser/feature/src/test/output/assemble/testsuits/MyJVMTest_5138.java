public class MyJVMTest_5138 {

    static int i = 0;

    int m(int i) {
        throw new AssertionError();
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5138().m(i);
    }
}
