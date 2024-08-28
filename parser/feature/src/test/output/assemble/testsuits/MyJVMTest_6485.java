public class MyJVMTest_6485 {

    static long address = 0;

    long getLong(long address) {
        return 0L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6485().getLong(address));
    }
}
