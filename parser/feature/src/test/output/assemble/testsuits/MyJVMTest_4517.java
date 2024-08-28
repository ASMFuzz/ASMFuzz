import javax.management.*;

public class MyJVMTest_4517 {

    String getCanonicalName() {
        return "bogus:canonical=name";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4517().getCanonicalName());
    }
}
