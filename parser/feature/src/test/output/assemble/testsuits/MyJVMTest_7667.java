import java.util.*;

public class MyJVMTest_7667 {

    Object[][] getContents() {
        return new Object[][] { { "food", "Cheeseburger" }, { "drink", "Coke" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_7667().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_7667().getContents()[1]));
    }
}
