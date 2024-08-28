public class MyJVMTest_3969 {

    int fopt() {
        int i = 0;
        i = 8;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3969().fopt());
    }
}
