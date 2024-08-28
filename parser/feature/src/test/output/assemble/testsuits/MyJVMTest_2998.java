public class MyJVMTest_2998 {

    static int i = 1766156518;

    int signWOZero(int i) {
        return (i > 0) ? 1 : -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2998().signWOZero(i));
    }
}
