public class MyJVMTest_6697 {

    static long value = -7421579603400201620L;

    long unchecked(long value) {
        return value - 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6697().unchecked(value));
    }
}
