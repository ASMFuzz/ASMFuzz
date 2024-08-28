public class MyJVMTest_9518 {

    static Object lock = 505186744;

    static int[] initCount = {3,4,5,0,1861384610,1,4,7,0,9};

    static int[] completeCount = {441609913,0,9,-634526322,-1785408325,200136250,0,0,0,7};

    static int id = -1;

    int[] initialize(Object lock, int[] initCount, int[] completeCount) {
        this.lock = lock;
        this.initCount = initCount;
        this.completeCount = completeCount;
        return completeCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9518().initialize(lock, initCount, completeCount);
    }
}
