public class MyJVMTest_6672 {

    static int result = -545302489;

    static int expV = 9;

    static int expW = 5;

    static int expX = 2;

    static int expY = 1;

    static int expZ = 3;

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
        new MyJVMTest_6672().check(result, expV, expW, expX, expY, expZ);
    }
}
