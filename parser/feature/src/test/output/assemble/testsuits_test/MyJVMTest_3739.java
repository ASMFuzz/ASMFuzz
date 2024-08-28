public class MyJVMTest_3739 {

    static int[] array = { 7, -564367473, 9, 9, 1102131095, 8, 0, 6, 1, 1549561397 };

    static int ARRAY_SIZE = 10000;

    static int[] a = {0,8,455236540,7,1517363452,0,9,0,5,0};

    int[] fillArray(int[] array) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int val = (int) (Math.random() * Integer.MAX_VALUE);
            array[i] = val;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3739().fillArray(array);
    }
}
