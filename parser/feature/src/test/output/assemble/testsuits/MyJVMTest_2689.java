public class MyJVMTest_2689 {

    static byte[] input = { -29, 15, 125, -67, 105, -81, 28, 93, 43, 115 };

    static int start = 0;

    static byte[] target = { -30, -75, -26, 122, 28, 84, 6, 12, -32, -35 };

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
        System.out.println(new MyJVMTest_2689().hasTarget(input, start, target));
    }
}
