public class MyJVMTest_13319 {

    int fopt() {
        int i = 0;
        i = 8;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13319().fopt());
    }
}
