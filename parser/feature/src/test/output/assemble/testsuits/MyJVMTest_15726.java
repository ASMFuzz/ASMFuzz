public class MyJVMTest_15726 {

    void run() {
        try {
            System.out.println("");
        } catch (@TA Throwable e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15726().run();
    }
}
