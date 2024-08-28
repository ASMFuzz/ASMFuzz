import java.util.*;

public class MyJVMTest_17218 {

    Object[][] getContents() {
        return new Object[][] { { "food", "Cheeseburger" }, { "drink", "Coke" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17218().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_17218().getContents()[1]));
    }
}
