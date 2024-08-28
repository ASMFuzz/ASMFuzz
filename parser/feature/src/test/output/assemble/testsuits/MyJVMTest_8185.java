import java.util.Arrays;

public class MyJVMTest_8185 {

    String[] names() {
        return new String[] { "this$1", "innerparam" };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8185().names()));
    }
}
