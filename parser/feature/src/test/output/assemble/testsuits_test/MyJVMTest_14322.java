public class MyJVMTest_14322 {

    static long value = 9223372036854775807L;

    long unchecked(long value) {
        return value + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14322().unchecked(value));
    }
}
