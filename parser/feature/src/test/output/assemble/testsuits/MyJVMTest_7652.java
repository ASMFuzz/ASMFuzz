public class MyJVMTest_7652 {

    static int global = 1;

    static int i = 0;

    int fopt() {
        global = -2;
        return global;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7652().fopt());
    }
}
