public class MyJVMTest_583 {

    static byte[] allocatedArray = {-29,23,-33,67,-83,67,-113,121,-126,108};

    static int hashValue = 1;

    int getCurrentHashValue() {
        return allocatedArray.hashCode();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_583().getCurrentHashValue());
    }
}
