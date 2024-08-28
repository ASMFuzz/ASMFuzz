public class MyJVMTest_16168 {

    static int result = 1313230350;

    static int expV = 3;

    static int expW = 0;

    static int expX = -714758759;

    static int expY = 8;

    static int expZ = 0;

    static int v = 1;

    static int w = 2;

    static int x = 3;

    static int y = 4;

    static int z = 5;

    int check(int result, int expV, int expW, int expX, int expY, int expZ) {
        if (result != 19 || expV != v || expW != w || expX != x || expY != y || expZ != z) {
            throw new RuntimeException("wrong execution");
        }
        return expV;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16168().check(result, expV, expW, expX, expY, expZ);
    }
}
