public class MyJVMTest_6186 {

    static long value = -1953007637732465969L;

    static long alignment = 9223372036854775807L;

    long alignUp(long value, long alignment) {
        return (value + alignment - 1) & ~(alignment - 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6186().alignUp(value, alignment));
    }
}
