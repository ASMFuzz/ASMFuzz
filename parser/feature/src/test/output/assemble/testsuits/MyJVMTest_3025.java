public class MyJVMTest_3025 {

    static int i = 9;

    int emptyDefault(int i) {
        switch(i) {
            default:
                break;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3025().emptyDefault(i);
    }
}
