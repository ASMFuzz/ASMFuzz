public class MyJVMTest_15073 {

    static Double value = Double.MIN_VALUE;

    boolean informationLossDoubleToFloat(Double value) {
        if (value.isInfinite())
            return false;
        if (value.isNaN())
            return false;
        float f = (float) value.doubleValue();
        return f != value.doubleValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15073().informationLossDoubleToFloat(value));
    }
}
