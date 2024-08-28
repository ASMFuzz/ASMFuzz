import javax.management.*;

public class MyJVMTest_13905 {

    String getCanonicalName() {
        return "bogus:canonical=name";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13905().getCanonicalName());
    }
}
