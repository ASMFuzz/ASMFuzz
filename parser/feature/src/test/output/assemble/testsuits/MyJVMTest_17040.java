public class MyJVMTest_17040 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {0,0,106818727,-1360956874,4,6,4,1354252658,0,5};

    static int nextSize = 409429011;

    int setSizeSequence(int... sizes) {
        this.sizes = sizes;
        nextSize = 0;
        return sizes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17040().setSizeSequence(sizes);
    }
}
