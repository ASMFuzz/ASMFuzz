public class MyJVMTest_14123 {

    static byte[] array = { 63, -49, -86, 53, -49, -78, -27, 46, -49, 77 };

    byte[] test(byte[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14123().test(array);
    }
}
