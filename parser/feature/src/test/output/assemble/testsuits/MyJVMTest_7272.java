public class MyJVMTest_7272 {

    static Double value = Double.MAX_VALUE;

    boolean informationLossDoubleToByte(Double value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.doubleValue() > Byte.MAX_VALUE) || (value.doubleValue() < Byte.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7272().informationLossDoubleToByte(value));
    }
}
