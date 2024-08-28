public class MyJVMTest_7408 {

    static int publicStatic = 0;

    int publicStatic() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7408().publicStatic());
    }
}
