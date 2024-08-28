public class MyJVMTest_10439 {

    static int[] a = {8,1203216247,8,3,0,8,0,612823257,3,2};

    void testArray() {
        for (int a : a) {
            int a2 = a;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10439().testArray();
    }
}
