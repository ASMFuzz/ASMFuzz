public class MyJVMTest_11784 {

    static int i = 0;

    static int x = 8;

    int f(int i) {
        switch(i) {
            case 0:
                x = 0;
            case 1:
            case 2:
                x = 2;
                break;
            default:
                x = 3;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11784().f(i);
    }
}
