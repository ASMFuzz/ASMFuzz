public class MyJVMTest_8140 {

    static int ARRAY_SIZE = 10000;

    static int[] a = {5,0,0,8,-187001036,4,4,7,6,1572291831};

    static int[] b = {1,764120339,0,-1114019956,5,0,2,0,0,8};

    void test() {
        try {
            System.arraycopy(a, 0, b, 0, ARRAY_SIZE);
            throw new RuntimeException("test failed");
        } catch (NullPointerException ex) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8140().test();
    }
}
