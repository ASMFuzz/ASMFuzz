public class MyJVMTest_3390 {

    static int i = 5;

    static int counter0 = 3;

    static int counter = 1032049545;

    int foo(int i) throws Exception {
        if ((i & 1023) == 2) {
            counter0++;
            throw new Exception2();
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3390().foo(i);
    }
}
