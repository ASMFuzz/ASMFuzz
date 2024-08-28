import java.util.Arrays;

public class MyJVMTest_229 {

    String[] names() {
        return new String[] { "this$1", "param", "val$message" };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_229().names()));
    }
}
