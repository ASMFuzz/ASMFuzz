import java.util.Arrays;

public class MyJVMTest_9668 {

    static int index = -194555250;

    static int inc = 9;

    byte[] testArrayAllocation(int index, int inc) {
        int allocationCount = -1;
        byte[] result;
        for (; index < 10; index += inc) {
            if (inc == 42)
                return null;
            if (index == 42) {
                result = new byte[allocationCount];
                return result;
            }
            allocationCount++;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_9668().testArrayAllocation(index, inc)));
    }
}
