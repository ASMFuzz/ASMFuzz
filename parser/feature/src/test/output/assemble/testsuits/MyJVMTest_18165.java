public class MyJVMTest_18165 {

    static Long value = 6450062299204187755L;

    boolean informationLossLongToChar(Long value) {
        return (value.longValue() > Character.MAX_VALUE) || (value.longValue() < Character.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18165().informationLossLongToChar(value));
    }
}
