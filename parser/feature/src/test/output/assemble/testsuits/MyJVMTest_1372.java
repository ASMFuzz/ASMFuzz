public class MyJVMTest_1372 {

    static int index = 7;

    static int inc = -1188548426;

    static int[] array = new int[100];

    int testArrayAccess1(int index, int inc) {
        int storeIndex = -1;
        for (; index < 10; index += inc) {
            if (inc == 42)
                return;
            if (storeIndex > 0 && array[storeIndex] == 42)
                return;
            if (index == 42) {
                array[storeIndex] = 1;
                return;
            }
            storeIndex++;
        }
        return storeIndex;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1372().testArrayAccess1(index, inc);
    }
}
