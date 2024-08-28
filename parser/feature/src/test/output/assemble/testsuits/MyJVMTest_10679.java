public class MyJVMTest_10679 {

    int test3() {
        int[] src = new int[15];
        src[5] = 0x42;
        System.arraycopy(src, 5, src, 0, 10);
        return src[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10679().test3());
    }
}
