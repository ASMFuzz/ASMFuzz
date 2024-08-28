public class MyJVMTest_5521 {

    static int protectedStatic = 5;

    int protectedStatic() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5521().protectedStatic());
    }
}
