import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_8601 {

    static int id = 7;

    static int closeFailureBitMap = 5;

    static List<Integer> closedList = new ArrayList<Integer>();

    Resource createResource(int id, int closeFailureBitMap, List<Integer> closedList) throws Resource.CreateFailException {
        boolean closeSucceeds = (closeFailureBitMap & (1 << id)) == 0;
        return new Resource(id, true, closeSucceeds, closedList);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8601().createResource(id, closeFailureBitMap, closedList));
    }
}
