public class MyJVMTest_13908 {

    static int index = -1691814255;

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
        System.out.println(new MyJVMTest_13908().testArrayAccess3(index, b));
    }
}
