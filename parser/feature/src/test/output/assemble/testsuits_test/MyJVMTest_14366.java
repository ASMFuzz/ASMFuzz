public class MyJVMTest_14366 {

    static int copy_len = -504957235;

    static byte[] src_array = { 'a', 'b', 'c', 'd', 'e' };

    byte test(int copy_len) {
        byte[] dst_array = new byte[10];
        System.arraycopy(src_array, 0, dst_array, 1, copy_len);
        return dst_array[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14366().test(copy_len));
    }
}
