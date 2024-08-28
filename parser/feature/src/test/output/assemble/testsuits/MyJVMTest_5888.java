public class MyJVMTest_5888 {

    int test4() {
        int[] src = new int[15];
        System.arraycopy(src, 0, src, 5, 10);
        return src[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5888().test4());
    }
}
