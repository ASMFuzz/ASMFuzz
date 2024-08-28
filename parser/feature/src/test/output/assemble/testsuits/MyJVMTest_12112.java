public class MyJVMTest_12112 {

    void moo() {
        Integer i = 100;
        do {
            if (true) {
                return;
            } else {
                return;
            }
        } while (i++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12112().moo();
    }
}
