public class MyJVMTest_17201 {

    static int global = 0;

    static int i = 5;

    int fopt() {
        global = -2;
        return global;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17201().fopt());
    }
}
