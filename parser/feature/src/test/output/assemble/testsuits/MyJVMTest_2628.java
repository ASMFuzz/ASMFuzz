public class MyJVMTest_2628 {

    static int[] ia = new int[] { -1 };

    static long MASK = 9223372036854775807L;

    long doload(int[] ia) {
        return ia[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2628().doload(ia));
    }
}
