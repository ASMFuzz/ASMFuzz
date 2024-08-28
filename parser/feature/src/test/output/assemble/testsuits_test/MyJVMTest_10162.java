import java.util.ArrayList;

public class MyJVMTest_10162 {

    static long allocatedSize = 0;

    static long numOfAllocedObjs = 2831181667810103421L;

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
        System.out.println(new MyJVMTest_10162().getEvacList2());
    }
}
