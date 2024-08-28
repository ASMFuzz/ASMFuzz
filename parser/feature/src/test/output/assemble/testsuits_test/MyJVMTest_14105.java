public class MyJVMTest_14105 {

    void loo() {
        Integer i = 100;
        Integer j = 100;
        do {
            do {
                return;
            } while (i++ < 10);
        } while (j++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14105().loo();
    }
}
