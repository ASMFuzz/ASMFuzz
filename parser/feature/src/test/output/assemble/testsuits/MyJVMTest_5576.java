import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_5576 {

    static int id = -4140719;

    static int createFailureId = 1126439691;

    static int closeFailureBitMap = 7;

    static List<Integer> closedList = new ArrayList<Integer>();

    Resource createResource(int id, int createFailureId, int closeFailureBitMap, List<Integer> closedList) throws Resource.CreateFailException {
        if (id > createFailureId)
            throw new AssertionError("Resource " + id + " shouldn't be created");
        boolean createSucceeds = id != createFailureId;
        boolean closeSucceeds = (closeFailureBitMap & (1 << id)) == 0;
        return new Resource(id, createSucceeds, closeSucceeds, closedList);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5576().createResource(id, createFailureId, closeFailureBitMap, closedList));
    }
}
