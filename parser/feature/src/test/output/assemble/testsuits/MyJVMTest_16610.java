import java.util.Arrays;

public class MyJVMTest_16610 {

    String[] names() {
        return new String[] { "this$1", "innerparam", "val$message" };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16610().names()));
    }
}
