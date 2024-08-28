public class MyJVMTest_12676 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {3,0,8,0,2,0,4,4,0,4};

    static int nextSize = -713327406;

    static int pos = 0;

    static Object[] a = {0,0,7,8,6,0,0,3,0,2};

    boolean hasNext() {
        return pos < sizes[nextSize];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12676().hasNext());
    }
}
