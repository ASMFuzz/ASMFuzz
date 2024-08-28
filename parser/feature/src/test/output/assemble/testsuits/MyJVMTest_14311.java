public class MyJVMTest_14311 {

    void init(Object[] src, boolean[] dst) {
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i] != null ? false : true;
        }
    }

    void test() {
        Object[] src = new Object[34];
        boolean[] dst = new boolean[34];
        init(src, dst);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14311().test();
    }
}
