public class MyJVMTest_10647 {

    static int obj_size = 1750054594;

    static Object[] old_garbage = {0,7,4,0,4,0,2,1,9,0};

    static int old_index = 0;

    static int OLD_COUNT = 4;

    void allocate_garbage() {
        byte[] garbage = new byte[obj_size];
        old_garbage[Math.abs(++old_index % OLD_COUNT)] = garbage;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10647().allocate_garbage();
    }
}
