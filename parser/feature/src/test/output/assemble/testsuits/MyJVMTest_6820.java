public class MyJVMTest_6820 {

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static int[] sizes = {5,7,0,0,3,-1229363825,0,-1963231706,300198660,1404927554};

    static int nextSize = 8;

    int size() {
        return sizes[nextSize == sizes.length - 1 ? nextSize : nextSize++];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6820().size());
    }
}
