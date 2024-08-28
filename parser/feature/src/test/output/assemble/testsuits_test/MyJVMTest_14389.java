import java.util.*;

public class MyJVMTest_14389 {

    Object[][] getContents() {
        return new Object[][] { { "food", "Peking Duck" }, { "tea", "Oolong" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14389().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_14389().getContents()[1]));
    }
}
