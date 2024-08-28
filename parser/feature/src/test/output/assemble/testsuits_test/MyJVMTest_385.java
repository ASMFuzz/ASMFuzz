public class MyJVMTest_385 {

    static int val = -1919714362;

    int testRolIntZero(int val) {
        int count = 42;
        for (int i = 0; i < 4; i++) {
            if ((i % 2) == 0) {
                count = 0;
            }
        }
        int res = Integer.rotateLeft(val, count);
        if (res != val) {
            throw new RuntimeException("test_rol_int_zero failed: " + res + " != " + val);
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_385().testRolIntZero(val);
    }
}
