public class MyJVMTest_383 {

    static long value = -6558463505839470926L;

    static long alignment = -8659145609440674115L;

    long alignDown(long value, long alignment) {
        return value & ~(alignment - 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_383().alignDown(value, alignment));
    }
}
