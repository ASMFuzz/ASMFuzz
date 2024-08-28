public class MyJVMTest_2417 {

    static int counter = 0;

    void run() {
        ++counter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2417().run();
    }
}
