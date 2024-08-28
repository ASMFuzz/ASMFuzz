import java.util.ArrayList;

public class MyJVMTest_976 {

    static long allocatedSize = 9223372036854775807L;

    static long numOfAllocedObjs = 0;

    static ArrayList safeList = new ArrayList();

    static ArrayList allocList = new ArrayList();

    static ArrayList evacList0 = new ArrayList();

    static ArrayList evacList1 = new ArrayList();

    static ArrayList evacList2 = new ArrayList();

    static ArrayList evacList3 = new ArrayList();

    static ArrayList evacList4 = new ArrayList();

    static ArrayList evacList5 = new ArrayList();

    ArrayList getEvacList2() {
        return evacList2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_976().getEvacList2());
    }
}
