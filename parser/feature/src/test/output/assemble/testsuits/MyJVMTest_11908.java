import javax.script.*;

public class MyJVMTest_11908 {

    static ScriptEngineManager m = new ScriptEngineManager();

    ScriptEngine getJsEngine(ScriptEngineManager m) {
        ScriptEngine e = m.getEngineByName("nashorn");
        if (e == null && System.getProperty("java.runtime.name").startsWith("Java(TM)")) {
            throw new RuntimeException("no js engine found");
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11908().getJsEngine(m));
    }
}
