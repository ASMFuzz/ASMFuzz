public class MyJVMTest_13527 {

    static Double value = Double.MAX_VALUE;

    boolean informationLossDoubleToShort(Double value) {
        if (value.isInfinite())
            return true;
        if (value.isNaN())
            return true;
        return (value.doubleValue() > Short.MAX_VALUE) || (value.doubleValue() < Short.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13527().informationLossDoubleToShort(value));
    }
}
