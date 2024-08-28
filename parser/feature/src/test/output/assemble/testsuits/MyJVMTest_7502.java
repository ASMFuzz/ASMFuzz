public class MyJVMTest_7502 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {-973427945,0,0,0,6,852859109,0,1147252696,3,0};

    static int nextSize = 2;

    int setSizeSequence(int... sizes) {
        this.sizes = sizes;
        nextSize = 0;
        return sizes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7502().setSizeSequence(sizes);
    }
}
