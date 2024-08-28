public class MyJVMTest_6280 {

    static int a = 3;

    static int b = 2031733211;

    int addProtectedInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6280().addProtectedInner_Level2(a, b));
    }
}
