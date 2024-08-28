public class MyJVMTest_1275 {

    static long value = -9223372036854775808L;

    static int v = 6;

    long create(long value, int v) {
        if ((value | v) == 0) {
            return 0;
        }
        if (value < -31557014167219200L || value > 31556889864403199L) {
            throw new RuntimeException("error");
        }
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1275().create(value, v));
    }
}
