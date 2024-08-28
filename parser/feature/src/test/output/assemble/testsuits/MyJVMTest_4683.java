public class MyJVMTest_4683 {

    static int a = 0;

    static int b = 4;

    int addPublicInner_level2(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4683().addPublicInner_level2(a, b));
    }
}
