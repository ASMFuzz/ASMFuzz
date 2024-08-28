public class MyJVMTest_8337 {

    static int i = 6;

    int fopt() {
        i = 8;
        return i;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8337().fopt());
    }
}
