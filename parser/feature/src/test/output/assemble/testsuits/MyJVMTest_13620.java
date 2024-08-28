public class MyJVMTest_13620 {

    static int[] ia = new int[] { -1 };

    long loadUI2L(int[] ia) {
        return ia[0] & 0xFFFFFFFFL;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13620().loadUI2L(ia));
    }
}
