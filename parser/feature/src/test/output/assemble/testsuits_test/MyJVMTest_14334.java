public class MyJVMTest_14334 {

    static long p = 0;

    static long word_size = 0;

    boolean isNull() {
        return p == 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14334().isNull());
    }
}
