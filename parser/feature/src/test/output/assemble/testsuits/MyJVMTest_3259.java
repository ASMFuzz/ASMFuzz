public class MyJVMTest_3259 {

    static char[] arr = { '.', Character.MIN_VALUE, '0', 'q', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0' };

    static int SIZE = 60000;

    char[] arrayAbs(char[] arr) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (char) Math.abs(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3259().arrayAbs(arr);
    }
}
