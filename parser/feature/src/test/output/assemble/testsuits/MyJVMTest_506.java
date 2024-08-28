import java.util.Arrays;

public class MyJVMTest_506 {

    static int index = 3;

    static int inc = 4;

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
        System.out.println(Arrays.asList(new MyJVMTest_506().testArrayAllocation(index, inc)));
    }
}
