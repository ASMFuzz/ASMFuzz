import javax.script.*;

public class MyJVMTest_2627 {

    static ClassLoader mParam1 = null;

    static ScriptEngineManager m = new ScriptEngineManager(mParam1);

    ScriptEngine getJsEngine(ScriptEngineManager m) {
        ScriptEngine e = m.getEngineByName("nashorn");
        if (e == null && System.getProperty("java.runtime.name").startsWith("Java(TM)")) {
            throw new RuntimeException("no js engine found");
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2627().getJsEngine(m));
    }
}
