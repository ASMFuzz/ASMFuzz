public class MyJVMTest_6229 {

    static int a = 8;

    static int b = 5;

    int f1(int a, int b) {
        if (a == b)
            ;
        System.out.println("a == b");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6229().f1(a, b);
    }
}
