public class MyJVMTest_9677 {

    static int val = -511170675;

    int runTest(int val) {
        int result = Math.addExact(val, 1);
        int total = 0;
        for (int i = val; i < 200; i = Math.addExact(i, 1)) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9677().runTest(val));
    }
}
