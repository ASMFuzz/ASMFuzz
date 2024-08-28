public class MyJVMTest_172 {

    static byte[] allocatedArray = {17,-95,109,96,-12,116,-64,5,83,95};

    static int hashValue = 0;

    int getAllocatedSize() {
        return allocatedArray.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_172().getAllocatedSize());
    }
}
