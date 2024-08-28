public class MyJVMTest_12304 {

    static int i = 4;

    int signWOZero(int i) {
        return (i > 0) ? 1 : -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12304().signWOZero(i));
    }
}
