import java.util.Arrays;
import java.util.stream.Collectors;

public class MyJVMTest_5160 {

    static String params = "y8USVcb*NB";

    static String cmd = "we3DWU@rES";

    JdbCommand run(String... params) {
        return new JdbCommand("run " + Arrays.stream(params).collect(Collectors.joining(" ")));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5160().run(params));
    }
}
