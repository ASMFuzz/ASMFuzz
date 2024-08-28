public class MyJVMTest_52 {

    static int j = 7;

    static int intFld = 3;

    int staticMethod(int j) {
        int i = 1 + j;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_52().staticMethod(j));
    }
}
