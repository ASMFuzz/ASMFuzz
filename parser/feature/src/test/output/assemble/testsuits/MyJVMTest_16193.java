public class MyJVMTest_16193 {

    static long value = -7568023466582488552L;

    long unchecked(long value) {
        return value - 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16193().unchecked(value));
    }
}
