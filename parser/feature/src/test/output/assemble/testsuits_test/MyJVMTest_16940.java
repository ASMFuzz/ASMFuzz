public class MyJVMTest_16940 {

    static int publicStatic = 1152429661;

    int publicStatic() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16940().publicStatic());
    }
}
