public class MyJVMTest_5637 {

    static Double value = 0d;

    boolean informationLossDoubleToFloat(Double value) {
        if (value.isInfinite())
            return false;
        if (value.isNaN())
            return false;
        float f = (float) value.doubleValue();
        return f != value.doubleValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5637().informationLossDoubleToFloat(value));
    }
}
