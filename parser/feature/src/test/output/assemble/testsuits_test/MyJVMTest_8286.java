public class MyJVMTest_8286 {

    static String name = null;

    static byte[] hugeBuffer = {31,-53,64,-25,88,52,-80,-81,-46,62};

    void unAllocateMem() {
        hugeBuffer = null;
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8286().unAllocateMem();
    }
}
