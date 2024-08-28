public class MyJVMTest_12720 {

    static int i = 1;

    static int counter0 = 0;

    static int counter = 6;

    int foo(int i) throws Exception {
        if ((i & 1023) == 2) {
            counter0++;
            throw new Exception2();
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12720().foo(i);
    }
}
