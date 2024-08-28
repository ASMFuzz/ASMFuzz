import static java.lang.invoke.MethodHandles.*;

public class MyJVMTest_14808 {

    Lookup getLookupForPrivateSIC() {
        return lookup();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14808().getLookupForPrivateSIC());
    }
}
