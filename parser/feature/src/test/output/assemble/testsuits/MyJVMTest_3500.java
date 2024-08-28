public class MyJVMTest_3500 {

    static int i = 4;

    int emptyCase(int i) {
        switch(i) {
            case 1:
                break;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3500().emptyCase(i);
    }
}
