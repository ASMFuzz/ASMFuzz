import static java.lang.invoke.MethodHandles.*;

public class MyJVMTest_5383 {

    Lookup getLookupForPrivateSIC() {
        return lookup();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5383().getLookupForPrivateSIC());
    }
}
