public class MyJVMTest_10987 {

    static int i = 1;

    int test(int i) {
        switch(i) {
            case 0:
                break;
            case 1:
                System.out.println();
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10987().test(i);
    }
}
