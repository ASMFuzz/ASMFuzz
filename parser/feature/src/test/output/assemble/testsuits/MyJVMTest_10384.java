public class MyJVMTest_10384 {

    static int[] array = { 167873196, 0, -1465730768, 0, 913387965, 8, 9, 1, 9, 0 };

    int m(int[] array) {
        int c = 0;
        for (int i = 0; i < 256; i++) {
            c += array[i];
            array[i] = c;
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10384().m(array));
    }
}
