public class MyJVMTest_7630 {

    static int before = 3;

    static int after = 1927944615;

    int checkCapacity(int before, int after) {
        if (before != after) {
            throw new RuntimeException("capacity is expected to be unchanged: " + "before=" + before + " after=" + after);
        }
        return after;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7630().checkCapacity(before, after);
    }
}
