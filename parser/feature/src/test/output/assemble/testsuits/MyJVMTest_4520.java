public class MyJVMTest_4520 {

    static int index = 0;

    static boolean b = false;

    static int[] array = new int[100];

    int testArrayAccess3(int index, boolean b) {
        int storeIndex = Integer.MIN_VALUE;
        for (; index < 10; ++index) {
            if (b) {
                return 0;
            }
            if (index == 42) {
                return array[storeIndex - 1];
            }
            storeIndex = 0;
        }
        return array[42];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4520().testArrayAccess3(index, b));
    }
}
