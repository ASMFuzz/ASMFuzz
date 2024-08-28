public class MyJVMTest_3367 {

    void b() {
        int x = 1;
        int y = 2;
        System.out.println("x + y = " + x + y);
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3367().b();
    }
}
