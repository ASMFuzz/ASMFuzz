public class MyJVMTest_3658 {

    static int start = 1;

    static int stop = 1;

    static int field = 6;

    static int barrier = 0;

    static Object field2 = 0;

    int test(int start, int stop) {
        int[] array = new int[10];
        for (int j = 0; j < 10; j++) {
            barrier = 1;
            for (int i = 1; i < 10; i *= 2) {
                field2 = array;
                array = new int[10];
            }
        }
        int v = field;
        array[0] = v;
        return v + v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3658().test(start, stop));
    }
}
