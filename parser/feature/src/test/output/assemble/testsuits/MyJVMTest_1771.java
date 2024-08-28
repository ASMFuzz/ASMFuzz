public class MyJVMTest_1771 {

    static long startTime = 9223372036854775807L;

    static long endTime = 9223372036854775807L;

    void clear() {
        startTime = 0;
        endTime = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1771().clear();
    }
}
