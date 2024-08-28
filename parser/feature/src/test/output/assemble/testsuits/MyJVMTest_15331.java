public class MyJVMTest_15331 {

    static long value = 3996062013402312228L;

    long unchecked(long value) {
        return -value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15331().unchecked(value));
    }
}
