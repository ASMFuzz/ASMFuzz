public class MyJVMTest_13708 {

    static int ID = 1;

    int m() {
        System.out.println("Sub.m");
        return ID;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13708().m());
    }
}
