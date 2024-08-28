public class MyJVMTest_12331 {

    static int i = 0;

    int emptyDefault(int i) {
        switch(i) {
            default:
                break;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12331().emptyDefault(i);
    }
}
