public class MyJVMTest_5826 {

    static int[] a = {0,0,8,2,1136745578,2069432822,37498350,8,0,1092504975};

    static Iterable<Integer> b = null;

    void testIterable() {
        for (Integer b : b) {
            Integer b2 = b;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5826().testIterable();
    }
}
