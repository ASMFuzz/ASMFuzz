public class MyJVMTest_16659 {

    static Long value = 0;

    boolean informationLossLongToByte(Long value) {
        return (value.longValue() > Byte.MAX_VALUE) || (value.longValue() < Byte.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16659().informationLossLongToByte(value));
    }
}
