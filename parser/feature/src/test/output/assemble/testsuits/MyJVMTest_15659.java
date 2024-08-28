public class MyJVMTest_15659 {

    static long value = -9223372036854775808L;

    static long alignment = 0;

    long alignUp(long value, long alignment) {
        return (value + alignment - 1) & ~(alignment - 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15659().alignUp(value, alignment));
    }
}
