public class MyJVMTest_4204 {

    static Long value = 4728355236025551279L;

    boolean informationLossLongToShort(Long value) {
        return (value.longValue() > Short.MAX_VALUE) || (value.longValue() < Short.MIN_VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4204().informationLossLongToShort(value));
    }
}
