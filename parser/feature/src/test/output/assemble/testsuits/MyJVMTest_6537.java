public class MyJVMTest_6537 {

    static int i = 9;

    void foo(int i) throws Exception {
        if ((i & 1023) == 2) {
            counter0++;
            throw new Exception2();
        }
    }

    static int counter0 = 0;

    static int counter1 = 7;

    static int counter2 = 7;

    static int counter = 2;

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
        new MyJVMTest_6537().test(i);
    }
}
