public class MyJVMTest_17053 {

    int javaMethod(int i) {
        int k = 0;
        for (int j = 0; j < i; j++) {
            k += (i - j);
        }
        return k;
    }

    void run() {
        for (int i = 0; i < 1000; i++) {
            javaMethod(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17053().run();
    }
}
