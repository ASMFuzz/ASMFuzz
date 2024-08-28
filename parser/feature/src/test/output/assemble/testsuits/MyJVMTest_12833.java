public class MyJVMTest_12833 {

    static int i = 1;

    int emptyCase(int i) {
        switch(i) {
            case 1:
                break;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12833().emptyCase(i);
    }
}
