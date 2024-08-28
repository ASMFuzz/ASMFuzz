public class MyJVMTest_246 {

    static byte[] dummy = {-30,-45,16,55,-67,-36,-85,17,2,94};

    void run() {
        while (true) {
            dummy = new byte[4096];
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_246().run();
    }
}
