public class MyJVMTest_12696 {

    void b() {
        int x = 1;
        int y = 2;
        System.out.println("x + y = " + x + y);
        return;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12696().b();
    }
}
