public class MyJVMTest_5192 {

    static byte[] array = { -112, 101, 113, -123, 17, -95, -55, 11, 3, 62 };

    static int index = -1032046200;

    int intFromBigEndian(byte[] array, int index) {
        return (((array[index] & 0xff) << 24) | ((array[index + 1] & 0xff) << 16) | ((array[index + 2] & 0xff) << 8) | (array[index + 3] & 0xff));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5192().intFromBigEndian(array, index));
    }
}
