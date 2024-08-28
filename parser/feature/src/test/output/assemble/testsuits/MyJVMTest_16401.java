public class MyJVMTest_16401 {

    static int size = 128;

    static int i = 3;

    static byte[] ba = {5,-75,104,-72,13,-118,-112,9,80,42};

    int testStoreCapture() {
        byte[] bs = new byte[1];
        bs[0] = 1;
        return bs.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16401().testStoreCapture());
    }
}
