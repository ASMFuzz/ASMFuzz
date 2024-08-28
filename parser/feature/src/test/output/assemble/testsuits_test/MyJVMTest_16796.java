public class MyJVMTest_16796 {

    static Double value = Double.MAX_VALUE;

    boolean informationLossDoubleToByte(Double value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.doubleValue() > Byte.MAX_VALUE) || (value.doubleValue() < Byte.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16796().informationLossDoubleToByte(value));
    }
}
