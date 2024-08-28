public class MyJVMTest_11909 {

    static int[] ia = new int[] { -1 };

    static long MASK = -2932061524866132333L;

    long doload(int[] ia) {
        return ia[0] & MASK;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11909().doload(ia));
    }
}
