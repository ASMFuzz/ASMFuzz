public class MyJVMTest_7747 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {1175633820,1262418177,-1754380808,0,7,3,7,5,0,4};

    static int nextSize = 0;

    static int pos = 0;

    boolean hasNext() {
        return pos < sizes[nextSize];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7747().hasNext());
    }
}
