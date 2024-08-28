public class MyJVMTest_4627 {

    static int[] ia = { -1525249914, 7, 0, 0, 8, 0, 829784211, 8, -1511729955, 7 };

    static long MASK = 9223372036854775807L;

    long doload(int[] ia) {
        return ia[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4627().doload(ia));
    }
}
