import java.util.ArrayList;

public class MyJVMTest_9757 {

    static long allocatedSize = 7182022666653561462L;

    static long numOfAllocedObjs = 9223372036854775807L;

    static ArrayList safeList = new ArrayList();

    static ArrayList allocList = new ArrayList();

    static ArrayList evacList0 = new ArrayList();

    static ArrayList evacList1 = new ArrayList();

    static ArrayList evacList2 = new ArrayList();

    static ArrayList evacList3 = new ArrayList();

    static ArrayList evacList4 = new ArrayList();

    static ArrayList evacList5 = new ArrayList();

    ArrayList getEvacList0() {
        return evacList0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9757().getEvacList0());
    }
}
