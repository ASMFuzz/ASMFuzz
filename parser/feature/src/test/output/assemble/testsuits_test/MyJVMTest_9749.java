public class MyJVMTest_9749 {

    static byte[] allocatedArray = {86,11,117,26,98,19,65,95,40,38};

    static int hashValue = 0;

    int getCurrentHashValue() {
        return allocatedArray.hashCode();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9749().getCurrentHashValue());
    }
}
