public class MyJVMTest_17907 {

    static byte[] buffer = new byte[16384];

    void makeBuffer() {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) (i % 128);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17907().makeBuffer();
    }
}
