public class MyJVMTest_16030 {

    static int i = -892361307;

    void foo(int i) throws Exception {
        if ((i & 1023) == 2) {
            counter0++;
            throw new Exception2();
        }
    }

    static int counter0 = 5;

    static int counter1 = -1275427886;

    static int counter2 = 109227323;

    static int counter = -840300725;

    int test(int i) throws Exception {
        try {
            foo(i);
        } catch (Exception e) {
            if (e instanceof Exception1) {
                counter1++;
            } else if (e instanceof Exception2) {
                counter2++;
            }
            counter++;
            throw e;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16030().test(i);
    }
}
