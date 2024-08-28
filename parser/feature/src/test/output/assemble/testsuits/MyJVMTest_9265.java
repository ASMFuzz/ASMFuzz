import javax.script.*;

public class MyJVMTest_9265 {

    static ScriptEngineManager m = new ScriptEngineManager();

    ScriptEngine getJsEngine(ScriptEngineManager m) {
        return m.getEngineByName("nashorn");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9265().getJsEngine(m));
    }
}
