public class MyJVMTest_17862 {

    static String name = null;

    static byte[] hugeBuffer = {-93,-48,117,39,-71,-42,5,-69,64,-49};

    void unAllocateMem() {
        hugeBuffer = null;
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17862().unAllocateMem();
    }
}
