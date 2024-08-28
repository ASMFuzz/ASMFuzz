public class MyJVMTest_4288 {

    static long value = 7208373241521968822L;

    long checkMethod(long value) {
        return Math.decrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4288().checkMethod(value));
    }
}
