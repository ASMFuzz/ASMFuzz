public class MyJVMTest_9904 {

    static int count = 9;

    int callee(int count) {
        int res = 0;
        for (int i = 0; i < count; i++) {
            for (int k = 0; k < count; k++) {
                res = res + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9904().callee(count));
    }
}
