public class MyJVMTest_13677 {

    static int ID = 2;

    int m() {
        System.out.println("Super.m");
        return ID;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13677().m());
    }
}
