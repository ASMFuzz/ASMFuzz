import javax.script.*;

public class MyJVMTest_119 {

    static ClassLoader mParam1 = null;

    static ScriptEngineManager m = new ScriptEngineManager(mParam1);

    ScriptEngine getJsEngine(ScriptEngineManager m) {
        return m.getEngineByName("nashorn");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_119().getJsEngine(m));
    }
}
