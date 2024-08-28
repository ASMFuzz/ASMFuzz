public class MyJVMTest_5141 {

    static int value = 93;

    int runTest(int value) {
        int v = value + value;
        int sum = 0;
        if (v < 4032) {
            for (int i = 0; i < 1023; ++i) {
                sum += Math.addExact(value, value);
            }
        } else {
            for (int i = 0; i < 321; ++i) {
                sum += Math.addExact(value, value);
            }
        }
        return sum + v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5141().runTest(value));
    }
}
