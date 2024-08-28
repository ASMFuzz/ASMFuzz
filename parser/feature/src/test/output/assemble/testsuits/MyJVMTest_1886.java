import java.util.ArrayList;

public class MyJVMTest_1886 {

    static boolean check = false;

    ArrayList<Integer> testme(boolean check) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        for (@SuppressWarnings("unchecked") Integer i : aList) {
            System.out.println("checking");
        }
        for (@SuppressWarnings("unusedLocal") Integer i : aList) {
            System.out.println("checking");
        }
        return aList;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1886().testme(check);
    }
}
