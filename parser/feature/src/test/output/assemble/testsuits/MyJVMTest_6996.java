import java.io.*;

public class MyJVMTest_6996 {

    static String processTrapScriptParam1Param1 = "&Iyx{Sm]7(";

    static File processTrapScriptParam1 = new File(processTrapScriptParam1Param1);

    static String processTrapScriptParam2 = "'U\\4/cf|i4";

    static File processTrapScript = new File(processTrapScriptParam1, processTrapScriptParam2);

    File createScript(File processTrapScript) throws IOException {
        processTrapScript.deleteOnExit();
        FileWriter fstream = new FileWriter(processTrapScript);
        try (BufferedWriter out = new BufferedWriter(fstream)) {
            out.write("#!/bin/bash\n" + "echo \\\"ProcessTrap.sh started: trapping SIGTERM/SIGINT\\\"\n" + "trap bashtrap SIGTERM SIGINT\n" + "bashtrap()\n" + "{\n" + "    echo \\\"SIGTERM/SIGINT detected!\\\"\n" + "}\n" + "\n" + "while :\n" + "do\n" + "    sleep 1;\n" + "done\n");
        }
        processTrapScript.setExecutable(true, true);
        return processTrapScript;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6996().createScript(processTrapScript);
    }
}
