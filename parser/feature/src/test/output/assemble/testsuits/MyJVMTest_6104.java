public class MyJVMTest_6104 {

    static long value = 0;

    long checkMethod(long value) {
        return Math.negateExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6104().checkMethod(value));
    }
}
