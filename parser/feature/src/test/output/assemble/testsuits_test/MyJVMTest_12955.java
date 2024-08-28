import java.util.*;

public class MyJVMTest_12955 {

    static List rawList = new ArrayList();

    static List<?> unboundList = new ArrayList<?>();

    List<?> test(List rawList, List<?> unboundList) {
        Throwable t0 = (Throwable) Collections.emptyList();
        Throwable t1 = (Throwable) rawList;
        Throwable t2 = (Throwable) unboundList;
        Object o = unboundList;
        Throwable t3 = (Throwable) o;
        return unboundList;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12955().test(rawList, unboundList);
    }
}
