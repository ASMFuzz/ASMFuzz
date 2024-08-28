public class MyJVMTest_4123 {

    void display() throws Exception {
        val += 10;
        throw new Exception(" Dummy Exception...");
    }

    static int val = 100;

    void playWithThis() {
        try {
            display();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4123().playWithThis();
    }
}
