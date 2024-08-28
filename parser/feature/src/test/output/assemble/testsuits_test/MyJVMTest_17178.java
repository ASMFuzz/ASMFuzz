public class MyJVMTest_17178 {

    static int before = 1808399738;

    static int after = 1684468351;

    int checkCapacity(int before, int after) {
        if (before != after) {
            throw new RuntimeException("capacity is expected to be unchanged: " + "before=" + before + " after=" + after);
        }
        return after;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17178().checkCapacity(before, after);
    }
}
