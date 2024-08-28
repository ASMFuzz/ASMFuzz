public class MyJVMTest_13962 {

    static int a = 5;

    static int b = 6;

    int addPublicInner_Level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13962().addPublicInner_Level2(a, b));
    }
}
