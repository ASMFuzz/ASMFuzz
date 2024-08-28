public class MyJVMTest_9193 {

    static int j = 0;

    static int intFld = 3;

    int staticMethod(int j) {
        int i = 1 + j;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9193().staticMethod(j));
    }
}
