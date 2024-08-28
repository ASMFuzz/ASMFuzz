public class MyJVMTest_4334 {

    static int ID = 1;

    int m() {
        System.out.println("Sub.m");
        return ID;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4334().m());
    }
}
