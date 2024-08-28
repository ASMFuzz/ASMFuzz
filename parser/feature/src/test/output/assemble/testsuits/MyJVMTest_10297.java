import java.util.ArrayList;

public class MyJVMTest_10297 {

    static long allocatedSize = 2955996873404799496L;

    static long numOfAllocedObjs = -8783566207317190798L;

    static ArrayList safeList = new ArrayList();

    static ArrayList allocList = new ArrayList();

    static ArrayList evacList0 = new ArrayList();

    static ArrayList evacList1 = new ArrayList();

    static ArrayList evacList2 = new ArrayList();

    static ArrayList evacList3 = new ArrayList();

    static ArrayList evacList4 = new ArrayList();

    static ArrayList evacList5 = new ArrayList();

    ArrayList getEvacList3() {
        return evacList3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10297().getEvacList3());
    }
}
