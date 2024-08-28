public class MyJVMTest_6511 {

    static int i = 6;

    static int age = 100;

    static boolean updated = false;

    int addAge(int i) throws InterruptedException {
        wait(100);
        age += i;
        updated = true;
        notifyAll();
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6511().addAge(i);
    }
}
