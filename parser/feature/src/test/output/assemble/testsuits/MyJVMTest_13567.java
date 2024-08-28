public class MyJVMTest_13567 {

    static Long value = 0;

    boolean informationLossLongToShort(Long value) {
        return (value.longValue() > Short.MAX_VALUE) || (value.longValue() < Short.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13567().informationLossLongToShort(value));
    }
}
