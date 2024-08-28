import java.util.ArrayList;

public class MyJVMTest_1727 {

    static long allocatedSize = -9223372036854775808L;

    static long numOfAllocedObjs = 9223372036854775807L;

    static ArrayList safeList = new ArrayList();

    static ArrayList allocList = new ArrayList();

    static ArrayList evacList0 = new ArrayList();

    static ArrayList evacList1 = new ArrayList();

    static ArrayList evacList2 = new ArrayList();

    static ArrayList evacList3 = new ArrayList();

    static ArrayList evacList4 = new ArrayList();

    static ArrayList evacList5 = new ArrayList();

    void incNumOfAllocedObjs() {
        numOfAllocedObjs++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1727().incNumOfAllocedObjs();
    }
}
