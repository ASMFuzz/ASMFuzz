public class MyJVMTest_12893 {

    static Runnable r = () -> {
    };

    static int threadNum = 0;

    static int obj_size = 0;

    static Object[] old_garbage = {2,3,4,725782469,6,9,7,0,0,8};

    static int OLD_COUNT = 4;

    static String THREAD_NAME = "TestGreyRH-";

    Thread newThread(Runnable r) {
        return new Thread(r, THREAD_NAME + (threadNum++));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12893().newThread(r));
    }
}
