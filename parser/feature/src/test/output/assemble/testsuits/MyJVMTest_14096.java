public class MyJVMTest_14096 {

    static int p = -301228362;

    static int x = -1152898213;

    static int y = -2117248975;

    static int q = 4;

    int interpreted(int p, int x, int y) {
        return (x < y) ? q + (x - y) : (x - y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14096().interpreted(p, x, y));
    }
}
