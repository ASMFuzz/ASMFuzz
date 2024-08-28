public class MyJVMTest_13078 {

    static int[] array = { 3, 322277866, 4, -2145612896, 6, 3, 2, -1431987593, 0, 0 };

    static int ARRAY_SIZE = 10000;

    static int[] a = {1799229337,2,-634571945,5,4,0,6,8,7,0};

    int[] fillArray(int[] array) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int val = (int) (Math.random() * Integer.MAX_VALUE);
            array[i] = val;
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13078().fillArray(array);
    }
}
