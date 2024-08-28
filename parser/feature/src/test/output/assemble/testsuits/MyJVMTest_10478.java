public class MyJVMTest_10478 {

    static long value = 5793473685874655035L;

    static int v = -1699218534;

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
        System.out.println(new MyJVMTest_10478().create(value, v));
    }
}
