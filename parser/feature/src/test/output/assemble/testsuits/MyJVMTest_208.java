public class MyJVMTest_208 {

    static int i1 = 9;

    static int i2 = 1403666868;

    static int i3 = 0;

    static int i4 = 3;

    static int i5 = 0;

    static int i6 = 8;

    static int capacity = 2;

    static int first = 1;

    static int last = 2;

    int test(int i1, int i2, int i3, int i4, int i5, int i6) {
        final int result;
        if (last >= first) {
            result = last - first;
        } else {
            result = last - first + capacity;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_208().test(i1, i2, i3, i4, i5, i6));
    }
}
