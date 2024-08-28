public class MyJVMTest_17711 {

    static int ARRAY_SIZE = 10000;

    static int[] a = {-1363040393,0,6,4,1452902056,0,116672195,0,0,803132548};

    static int[] b = {0,1060488657,6,1172347480,-197265595,8,7,-1237359531,9,9};

    void test() {
        try {
            System.arraycopy(a, 0, b, 0, ARRAY_SIZE);
            throw new RuntimeException("test failed");
        } catch (NullPointerException ex) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17711().test();
    }
}
