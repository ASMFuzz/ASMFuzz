public class MyJVMTest_13095 {

    int fopt() {
        int i = 0;
        i = 1;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13095().fopt());
    }
}
