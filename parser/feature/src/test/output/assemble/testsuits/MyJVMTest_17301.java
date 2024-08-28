public class MyJVMTest_17301 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {0,6,7,6,0,266466193,0,1,1,0};

    static int nextSize = 9;

    static int pos = 0;

    boolean hasNext() {
        return pos < sizes[nextSize];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17301().hasNext());
    }
}
