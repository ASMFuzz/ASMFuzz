public class MyJVMTest_904 {

    static int age = 100;

    static boolean updated = false;

    int getAge() throws InterruptedException {
        wait(100);
        updated = false;
        notifyAll();
        return age;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_904().getAge());
    }
}
