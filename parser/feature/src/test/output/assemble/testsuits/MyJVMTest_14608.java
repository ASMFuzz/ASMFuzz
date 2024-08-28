public class MyJVMTest_14608 {

    static byte[] array = { 22, 110, -107, 79, 86, -111, 84, 73, -18, -116 };

    static int index = 0;

    int intFromBigEndian(byte[] array, int index) {
        return (((array[index] & 0xff) << 24) | ((array[index + 1] & 0xff) << 16) | ((array[index + 2] & 0xff) << 8) | (array[index + 3] & 0xff));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14608().intFromBigEndian(array, index));
    }
}
