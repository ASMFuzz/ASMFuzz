public class MyJVMTest_13341 {

    static int a = 4;

    static int b = 0;

    int addPublicInner(int a, int b) {
        return a + b + 20;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13341().addPublicInner(a, b));
    }
}
