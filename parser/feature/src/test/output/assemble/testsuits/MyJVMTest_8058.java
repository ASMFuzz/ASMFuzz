public class MyJVMTest_8058 {

    static long v = -9223372036854775808L;

    static long acc = 9223372036854775807L;

    long add(long v) {
        acc += v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8058().add(v);
    }
}
