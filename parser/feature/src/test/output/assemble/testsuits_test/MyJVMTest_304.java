public class MyJVMTest_304 {

    static int i = 8;

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
        new MyJVMTest_304().m(i);
    }
}
