public class MyJVMTest_14316 {

    static int[] ia = new int[] { -1 };

    long loadI2L(int[] ia) {
        return ia[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14316().loadI2L(ia));
    }
}
