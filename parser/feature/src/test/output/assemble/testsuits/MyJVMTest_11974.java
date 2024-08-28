public class MyJVMTest_11974 {

    static byte[] input = { 22, -12, 11, 68, 73, 43, 35, -35, -19, 37 };

    static int start = -775777895;

    static byte[] target = { 47, 64, -58, -100, 44, -85, 12, -74, -84, 123 };

    boolean hasTarget(byte[] input, int start, byte[] target) {
        for (int i = 0; i < target.length; i++) {
            if (start + i == input.length) {
                return false;
            }
            if (input[start + i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11974().hasTarget(input, start, target));
    }
}
