public class MyJVMTest_15757 {

    static int a = 3;

    static int b = 8;

    int addProtectedInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15757().addProtectedInner_Level2(a, b));
    }
}
