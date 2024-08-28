public class MyJVMTest_4725 {

    static byte[] array = { -1, -39, -38, 49, 62, -71, 85, 4, 1, -47 };

    byte[] test(byte[] array) {
        array[0] = 1;
        array[array.length - 1] = 1;
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4725().test(array);
    }
}
