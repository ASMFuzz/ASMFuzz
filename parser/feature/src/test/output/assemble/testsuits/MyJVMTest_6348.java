public class MyJVMTest_6348 {

    static int la = 0;

    static int lb = 1;

    int check(int la, int lb) throws Exception {
        if (la != lb) {
            System.err.println("Length is " + la + ", should be " + lb);
            throw new Exception("Encoding Error");
        } else {
            System.err.println("Correct, which is " + lb);
        }
        return lb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6348().check(la, lb);
    }
}
