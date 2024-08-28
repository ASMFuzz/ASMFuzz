public class MyJVMTest_4866 {

    static Long value = -9223372036854775808L;

    boolean informationLossLongToInt(Long value) {
        return (value.longValue() > Integer.MAX_VALUE) || (value.longValue() < Integer.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4866().informationLossLongToInt(value));
    }
}
