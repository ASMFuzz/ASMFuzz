import java.util.ArrayList;

public class MyJVMTest_16844 {

    static long allocatedSize = 4822848926510927570L;

    static long numOfAllocedObjs = 0;

    static ArrayList safeList = new ArrayList();

    static ArrayList allocList = new ArrayList();

    static ArrayList evacList0 = new ArrayList();

    static ArrayList evacList1 = new ArrayList();

    static ArrayList evacList2 = new ArrayList();

    static ArrayList evacList3 = new ArrayList();

    static ArrayList evacList4 = new ArrayList();

    static ArrayList evacList5 = new ArrayList();

    ArrayList getEvacList5() {
        return evacList5;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16844().getEvacList5());
    }
}
