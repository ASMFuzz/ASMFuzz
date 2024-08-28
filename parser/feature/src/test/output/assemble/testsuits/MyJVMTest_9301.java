public class MyJVMTest_9301 {

    static int val = 100;

    void display() throws Exception {
        val += 10;
        throw new Exception(" Dummy Exception...");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9301().display();
    }
}
