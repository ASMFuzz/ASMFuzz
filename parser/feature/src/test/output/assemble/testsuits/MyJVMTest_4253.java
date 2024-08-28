public class MyJVMTest_4253 {

    static int[] ia = new int[] { -1 };

    long loadUI2L(int[] ia) {
        return ia[0] & 0xFFFFFFFFL;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4253().loadUI2L(ia));
    }
}
