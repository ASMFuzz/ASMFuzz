public class MyJVMTest_3349 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {9,5,0,3,3,7,0,-1302603645,2123788300,468662147};

    static int nextSize = 1;

    static int pos = 0;

    static Object[] a = {-1779748059,-443940681,-2024810729,0,1,6,5,0,1080616836,2053146062};

    boolean hasNext() {
        return pos < sizes[nextSize];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3349().hasNext());
    }
}
