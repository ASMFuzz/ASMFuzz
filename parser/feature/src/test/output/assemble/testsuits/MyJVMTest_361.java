public class MyJVMTest_361 {

    static Object lock = -2043663308;

    static int[] initCount = {1649673128,14322166,1118160025,5,-1740976798,1,8,0,3,9};

    static int[] completeCount = {3,5,2049054809,7,4,0,-1283911577,0,324038048,7};

    static int id = -1;

    int[] initialize(Object lock, int[] initCount, int[] completeCount) {
        this.lock = lock;
        this.initCount = initCount;
        this.completeCount = completeCount;
        return completeCount;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_361().initialize(lock, initCount, completeCount);
    }
}
