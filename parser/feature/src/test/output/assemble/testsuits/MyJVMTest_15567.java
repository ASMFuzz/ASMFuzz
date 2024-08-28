public class MyJVMTest_15567 {

    static long value = 1478704449622648876L;

    long checkMethod(long value) {
        return Math.negateExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15567().checkMethod(value));
    }
}
