public class MyJVMTest_1239 {

    static int[] a = {0,0,0,7,0,4,7,9,0,-1031978072};

    void testArray() {
        for (int a : a) {
            int a2 = a;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1239().testArray();
    }
}
