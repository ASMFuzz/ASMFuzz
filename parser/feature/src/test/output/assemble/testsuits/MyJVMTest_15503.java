public class MyJVMTest_15503 {

    static int i = 1105525700;

    static long f0 = 9223372036854775807L, f1 = -5635772699022663177L;

    Object get(int i) {
        return new long[] { f0, f1 }[i];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15503().get(i));
    }
}
