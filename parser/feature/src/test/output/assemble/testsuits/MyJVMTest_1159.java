public class MyJVMTest_1159 {

    static int i = 0;

    static long f0 = -9223372036854775808L, f1 = -9223372036854775808L;

    static long sf0 = 9223372036854775807L, sf1 = 9223372036854775807L;

    Object getStatic(int i) {
        return new long[] { sf0, sf1 }[i];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1159().getStatic(i));
    }
}
