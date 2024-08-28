public class MyJVMTest_6891 {

    static int size = 128;

    static int i = 1;

    static byte[] ba = {71,125,96,107,70,17,52,19,93,77};

    int testStoreCapture() {
        byte[] bs = new byte[1];
        bs[0] = 1;
        return bs.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6891().testStoreCapture());
    }
}
