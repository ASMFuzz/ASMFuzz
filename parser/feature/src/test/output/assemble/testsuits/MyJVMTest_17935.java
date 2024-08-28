import java.util.Arrays;

public class MyJVMTest_17935 {

    Object[][] getContents() {
        return new Object[][] { { "type", "Non-ResourceBundle" } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17935().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_17935().getContents()[1]));
    }
}
