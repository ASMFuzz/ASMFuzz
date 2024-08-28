import java.lang.invoke.MethodHandles;

public class MyJVMTest_12537 {

    MethodHandles.Lookup getLookupIn() {
        return MethodHandles.lookup().in(ConcurrentHashMap.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12537().getLookupIn());
    }
}
