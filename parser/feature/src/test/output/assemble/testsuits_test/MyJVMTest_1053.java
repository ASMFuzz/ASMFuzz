public class MyJVMTest_1053 {

    static Double value = 0d;

    boolean informationLossDoubleToInt(Double value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.doubleValue() > Integer.MAX_VALUE) || (value.doubleValue() < Integer.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1053().informationLossDoubleToInt(value));
    }
}
