public class MyJVMTest_9540 {

    static long value = -1226166593798774646L;

    static long alignment = 0;

    long alignDown(long value, long alignment) {
        return value & ~(alignment - 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9540().alignDown(value, alignment));
    }
}
