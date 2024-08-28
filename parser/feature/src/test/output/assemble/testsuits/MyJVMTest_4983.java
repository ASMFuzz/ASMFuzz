import java.util.*;

public class MyJVMTest_4983 {

    Object[][] getContents() {
        return new Object[][] { { "food", "Peking Duck" }, { "tea", "Oolong" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4983().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_4983().getContents()[1]));
    }
}
