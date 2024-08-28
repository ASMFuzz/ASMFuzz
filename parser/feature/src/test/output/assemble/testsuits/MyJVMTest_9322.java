public class MyJVMTest_9322 {

    static byte[] allocatedArray = {-48,-80,-58,40,-83,-3,-3,-118,-31,-100};

    static int hashValue = 0;

    int getAllocatedSize() {
        return allocatedArray.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9322().getAllocatedSize());
    }
}
