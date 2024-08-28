public class MyJVMTest_16324 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {0,0,346016347,0,5,0,0,6,-764375718,8};

    static int nextSize = 0;

    int size() {
        return sizes[nextSize == sizes.length - 1 ? nextSize : nextSize++];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16324().size());
    }
}
