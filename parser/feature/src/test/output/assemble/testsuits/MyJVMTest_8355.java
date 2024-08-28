import java.util.Arrays;

public class MyJVMTest_8355 {

    Object[][] getContents() {
        return new Object[][] { { "type", "Non-ResourceBundle" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8355().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_8355().getContents()[1]));
    }
}
