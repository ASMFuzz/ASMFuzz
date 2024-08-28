import java.util.Arrays;

public class MyJVMTest_6670 {

    String[] names() {
        return new String[] { "this$1", "localparam", "val$message" };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6670().names()));
    }
}
