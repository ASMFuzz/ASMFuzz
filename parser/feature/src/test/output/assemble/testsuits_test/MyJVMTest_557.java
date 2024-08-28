import java.util.ArrayList;

public class MyJVMTest_557 {

    static boolean check = false;

    ArrayList<Integer> testme(boolean check) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        for (@Ann(Color.red) Integer i : aList) {
            System.out.println("checking");
        }
        return aList;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_557().testme(check);
    }
}
