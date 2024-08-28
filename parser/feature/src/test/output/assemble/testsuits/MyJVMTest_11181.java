public class MyJVMTest_11181 {

    static int[] array = { 9, 6, 724935624, 7, 2143188771, 0, 0, 1059902334, 0, 1434333202 };

    static int field = -1680800566;

    static int barrier = -849384969;

    int test1(int[] array) {
        int res = 1;
        for (int i = 0; i < 10; i++) {
            barrier = 1;
            for (int j = 0; j < 2000; j++) {
                array[0] = j;
                res *= j;
            }
        }
        return field + res + field * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11181().test1(array));
    }
}
