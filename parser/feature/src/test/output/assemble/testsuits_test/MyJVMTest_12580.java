public class MyJVMTest_12580 {

    static char[] arr = { ')', 'v', Character.MIN_VALUE, '^', '0', Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE };

    static int SIZE = 60000;

    char[] arrayAbs(char[] arr) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (char) Math.abs(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12580().arrayAbs(arr);
    }
}
