public class MyJVMTest_10529 {

    static Float value = Float.MIN_VALUE;

    boolean informationLossFloatToShort(Float value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.floatValue() > Short.MAX_VALUE) || (value.floatValue() < Short.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10529().informationLossFloatToShort(value));
    }
}
