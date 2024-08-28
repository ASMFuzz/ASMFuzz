public class MyJVMTest_11370 {

    static int i = 0;

    Object bar(int i) {
        if (i % 2 == 0) {
            return new A();
        } else {
            return new B();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11370().bar(i));
    }
}
