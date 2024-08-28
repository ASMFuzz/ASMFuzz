public class MyJVMTest_384 {

    static int[] array = { 1952621100, 0, 1, 3, 4, 0, 0, 0, 0, 0 };

    static int ARRAY_SIZE = 10000;

    static int[] a = {2086849230,0,0,-826411899,0,0,0,0,1976382963,6};

    static int[] b = {7,6,2,0,9,0,723107410,650536755,2121769762,0};

    int[] fillArray(int[] array) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int val = (int) (Math.random() * Integer.MAX_VALUE);
            array[i] = val;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_384().fillArray(array);
    }
}
