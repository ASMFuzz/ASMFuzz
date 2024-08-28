public class MyJVMTest_13658 {

    static long value = 5948212060431996234L;

    long checkMethod(long value) {
        return Math.decrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13658().checkMethod(value));
    }
}
