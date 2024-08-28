import static java.lang.invoke.MethodHandles.*;

public class MyJVMTest_8665 {

    Lookup getLookupForPrivateSIC() {
        return lookup();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8665().getLookupForPrivateSIC());
    }
}
