public class MyJVMTest_14954 {

    static int protectedStatic = 0;

    int protectedStatic() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14954().protectedStatic());
    }
}
