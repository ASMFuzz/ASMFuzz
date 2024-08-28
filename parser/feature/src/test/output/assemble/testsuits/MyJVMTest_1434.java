public class MyJVMTest_1434 {

    static int obj_size = -1396918052;

    static Object[] old_garbage = {9,0,6,7,0,0,4,3,0,0};

    static int old_index = 0;

    static int OLD_COUNT = 4;

    void allocate_garbage() {
        byte[] garbage = new byte[obj_size];
        old_garbage[Math.abs(++old_index % OLD_COUNT)] = garbage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1434().allocate_garbage();
    }
}
