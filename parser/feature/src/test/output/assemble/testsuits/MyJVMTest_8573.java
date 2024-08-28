public class MyJVMTest_8573 {

    static Long value = 0;

    boolean informationLossLongToChar(Long value) {
        return (value.longValue() > Character.MAX_VALUE) || (value.longValue() < Character.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8573().informationLossLongToChar(value));
    }
}
