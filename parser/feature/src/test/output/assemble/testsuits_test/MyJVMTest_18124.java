import java.security.*;

public class MyJVMTest_18124 {

    String getAlgorithm() {
        return "NoProvider";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18124().getAlgorithm());
    }
}
