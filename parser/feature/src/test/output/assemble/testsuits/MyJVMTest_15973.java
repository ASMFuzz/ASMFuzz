public class MyJVMTest_15973 {

    static long address = 9223372036854775807L;

    long getLong(long address) {
        return 0L;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15973().getLong(address));
    }
}
