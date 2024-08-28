import java.util.*;
import java.awt.datatransfer.DataFlavor;

public class MyJVMTest_10736 {

    static List<DataFlavor> flavors1 = new ArrayList<DataFlavor>();

    static List<DataFlavor> flavors2 = new ArrayList<DataFlavor>();

    static String key = " `bkOcKnQp";

    boolean compareFlavors(List<DataFlavor> flavors1, List<DataFlavor> flavors2, String key) {
        for (DataFlavor flavor1 : flavors1) {
            boolean result = false;
            for (DataFlavor flavor2 : flavors2) {
                if (flavor1.equals(flavor2))
                    result = true;
            }
            if (!result)
                throw new RuntimeException("\n*** Error in verifyNewMappings()" + "\nmethod1: addFlavorForUnencodedNative(String nat, DataFlavor flav)" + "\nmethod2: List getFlavorsForNative(String nat)" + "\nString native: " + key + "\nAfter adding several mappings with addFlavorForUnencodedNative," + "\nthe returned list did not match the mappings that were added." + "\nEither the mapping was not included in the list, or the order was incorect.");
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10736().compareFlavors(flavors1, flavors2, key);
    }
}
