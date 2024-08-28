public class MyJVMTest_9541 {

    static int[] array = { 7, 9, 0, 6, 0, 0, 2, 3, 1, -1029305059 };

    static int ARRAY_SIZE = 10000;

    static int[] a = {7,9,6,0,1373589455,-1191794596,0,0,5,1};

    static int[] b = {7,0,-937209195,754893231,0,6,5,7,7,9};

    int[] fillArray(int[] array) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int val = (int) (Math.random() * Integer.MAX_VALUE);
            array[i] = val;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9541().fillArray(array);
    }
}
