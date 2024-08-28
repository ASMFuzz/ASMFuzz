public class MyJVMTest_9456 {

    static int i = 9;

    int m(int i) {
        switch(i) {
            default:
                {
                    break;
                }
        }
        ;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9456().m(i);
    }
}
