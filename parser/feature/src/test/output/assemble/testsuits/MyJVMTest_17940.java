public class MyJVMTest_17940 {

    static PrimitivesTest other = null;

    static byte b = 1;

    static char c = 'c';

    static float f = 3.14159f;

    static long l = 3;

    static double d = 1.740;

    static int i = 4;

    static boolean z = true;

    static short s = 2;

    boolean equals(PrimitivesTest other) {
        if (b != other.b || c != other.c || f != other.f || l != other.l || d != other.d || i != other.i || s != other.s || z != other.z) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17940().equals(other));
    }
}
