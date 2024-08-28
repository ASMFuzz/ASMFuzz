public class MyJVMTest_11867 {

    static Double value = 0d;

    boolean informationLossDoubleToChar(Double value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.doubleValue() > Character.MAX_VALUE) || (value.doubleValue() < Character.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11867().informationLossDoubleToChar(value));
    }
}
