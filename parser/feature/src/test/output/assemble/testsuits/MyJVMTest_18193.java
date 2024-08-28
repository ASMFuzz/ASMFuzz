import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_18193 {

    static int id = 8;

    static int closeFailureBitMap = 6;

    static List<Integer> closedList = new ArrayList<Integer>();

    Resource createResource(int id, int closeFailureBitMap, List<Integer> closedList) throws Resource.CreateFailException {
        boolean closeSucceeds = (closeFailureBitMap & (1 << id)) == 0;
        return new Resource(id, true, closeSucceeds, closedList);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18193().createResource(id, closeFailureBitMap, closedList));
    }
}
