public class MyJVMTest_17627 {

    static long v = 0;

    static long acc = 9223372036854775807L;

    long add(long v) {
        acc += v;
        return v;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17627().add(v);
    }
}
