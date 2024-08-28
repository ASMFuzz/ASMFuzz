public class MyJVMTest_7459 {

    static int n = 1042258910;

    int bug(int n) {
        float f = 1;
        int i = 1;
        try {
            int x = 1 / n;
            f = 2;
            i = 2;
            int y = 2 / n;
        } catch (Exception ex) {
            f++;
            i++;
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7459().bug(n);
    }
}
