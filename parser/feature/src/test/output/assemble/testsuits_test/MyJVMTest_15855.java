public class MyJVMTest_15855 {

    static int value = 17;

    int runTest() {
        int sum = 0;
        for (int j = 0; j < 100000; j = Math.addExact(j, 1)) {
            sum = 1;
            for (int i = 0; i < 5; ++i) {
                sum *= value;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15855().runTest());
    }
}
