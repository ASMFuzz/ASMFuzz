public class MyJVMTest_15828 {

    static int la = 1516126015;

    static int lb = 292306124;

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
        new MyJVMTest_15828().check(la, lb);
    }
}
