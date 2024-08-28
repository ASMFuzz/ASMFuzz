import java.util.*;
import java.util.concurrent.*;

public class MyJVMTest_11364 {

    static Map<Object, Object> m = new HashMap<Object, Object>();

    Map<Object, Object> testMap(Map<Object, Object> m) {
        if (!(m.toString().equals("{}")))
            throw new Error();
        m.put("Harvey", m);
        if (!(m.toString().equals("{Harvey=(this Map)}")))
            throw new Error();
        m.clear();
        m.put(m, "Harvey");
        if (!(m.toString().equals("{(this Map)=Harvey}")))
            throw new Error();
        m.clear();
        m.hashCode();
        return m;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11364().testMap(m);
    }
}
