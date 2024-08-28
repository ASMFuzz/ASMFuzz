public class MyJVMTest_9955 {

    static int i = -412990294;

    static int f = 4;

    static int[] a = {1493614593,1,2,0,0,0,0,-39609122,-459855519,-1562333143};

    static int sz = -1558814028;

    static O o = null;

    int put(int i) {
        a[i % sz] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9955().put(i);
    }
}
