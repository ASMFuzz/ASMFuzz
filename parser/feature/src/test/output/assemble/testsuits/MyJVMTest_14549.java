import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_14549 {

    static List<Integer> closedList = new ArrayList<Integer>();

    static int createFailureId = 9;

    List<Integer> checkClosedList(List<Integer> closedList, int createFailureId) {
        List<Integer> expectedList = new ArrayList<Integer>(createFailureId);
        for (int i = createFailureId - 1; i >= 0; i--) expectedList.add(i);
        if (!closedList.equals(expectedList))
            throw new AssertionError("Closing sequence " + closedList + " != " + expectedList);
        return expectedList;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14549().checkClosedList(closedList, createFailureId);
    }
}
