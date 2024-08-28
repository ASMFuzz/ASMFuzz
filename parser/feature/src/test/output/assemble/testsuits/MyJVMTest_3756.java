public class MyJVMTest_3756 {

    int fopt() {
        int i = 0;
        i = 1;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3756().fopt());
    }
}
