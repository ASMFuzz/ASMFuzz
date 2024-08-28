public class MyJVMTest_2123 {

    static int i = -511053736;

    Object bar(int i) {
        if (i % 2 == 0) {
            return new A();
        } else {
            return new B();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2123().bar(i));
    }
}
