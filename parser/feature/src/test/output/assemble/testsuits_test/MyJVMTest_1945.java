public class MyJVMTest_1945 {

    static int[] array = { 8, 0, 0, 0, 0, 0, -417776172, 2, 7, 0 };

    static int field = -305351918;

    static int barrier = 0;

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
        System.out.println(new MyJVMTest_1945().test1(array));
    }
}
