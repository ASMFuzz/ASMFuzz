public class MyJVMTest_14266 {

    static Long value = 9223372036854775807L;

    boolean informationLossLongToInt(Long value) {
        return (value.longValue() > Integer.MAX_VALUE) || (value.longValue() < Integer.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14266().informationLossLongToInt(value));
    }
}
