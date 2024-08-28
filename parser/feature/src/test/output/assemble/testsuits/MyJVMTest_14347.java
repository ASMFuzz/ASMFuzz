public class MyJVMTest_14347 {

    static String a = "jl6CU`Xu-%";

    static String b = "WOCp!\"k`q_";

    static int v = -392537641;

    static int expected = -1373930249;

    static long start = -6312589824375820104L;

    static int ITERATIONS = 100000;

    int test_end(String a, String b, int v, int expected, long start) {
        long end = System.currentTimeMillis();
        int res = (v / ITERATIONS);
        System.out.print(" " + res);
        System.out.println(" time:" + (end - start));
        if (res != expected) {
            System.out.println("wrong indexOf result: " + res + ", expected " + expected);
            System.out.println("\"" + b + "\".indexOf(\"" + a + "\")");
            System.exit(97);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14347().test_end(a, b, v, expected, start);
    }
}
