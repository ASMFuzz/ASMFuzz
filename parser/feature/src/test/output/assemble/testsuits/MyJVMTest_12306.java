public class MyJVMTest_12306 {

    static Float value = Float.POSITIVE_INFINITY;

    boolean informationLossFloatToByte(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Byte.MAX_VALUE) || (value.floatValue() < Byte.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12306().informationLossFloatToByte(value));
    }
}
