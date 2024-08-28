public class MyJVMTest_726 {

    static int count = 3;

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
        System.out.println(new MyJVMTest_726().callee(count));
    }
}
