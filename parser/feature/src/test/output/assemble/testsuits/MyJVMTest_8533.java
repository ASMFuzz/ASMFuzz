import java.security.*;

public class MyJVMTest_8533 {

    String getAlgorithm() {
        return "NoProvider";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8533().getAlgorithm());
    }
}
