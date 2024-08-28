public class MyJVMTest_14076 {

    static int a = 0;

    static int b = 1;

    int addPublicInner_level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14076().addPublicInner_level2(a, b));
    }
}
