import java.net.URI;

public class MyJVMTest_13172 {

    static URI uri = null;

    static String description = "7.)4xWUt'B";

    String getDescription() {
        return description != null ? description : uri != null ? uri.getPath() : null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13172().getDescription());
    }
}
