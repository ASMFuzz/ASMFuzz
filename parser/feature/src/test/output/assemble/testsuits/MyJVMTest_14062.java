public class MyJVMTest_14062 {

    void run() {
        for (; ; ) {
            Object[] arrays = new Object[1024];
            for (int i = 0; i < arrays.length; i++) {
                arrays[i] = new int[1024];
            }
            System.gc();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14062().run();
    }
}
