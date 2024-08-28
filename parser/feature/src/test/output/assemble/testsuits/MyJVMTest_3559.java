public class MyJVMTest_3559 {

    static Runnable r = () -> {
    };

    static int threadNum = 0;

    static int obj_size = 0;

    static Object[] old_garbage = {1012950124,6,8,1,1848372111,8,1,2,0,6};

    static int OLD_COUNT = 4;

    static String THREAD_NAME = "TestGreyRH-";

    Thread newThread(Runnable r) {
        return new Thread(r, THREAD_NAME + (threadNum++));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3559().newThread(r));
    }
}
