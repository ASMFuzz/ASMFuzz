public class MyJVMTest_8329 {

    static byte[] buffer = new byte[16384];

    void makeBuffer() {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) (i % 128);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8329().makeBuffer();
    }
}
