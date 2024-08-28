import java.io.*;
import java.net.URI;

public class MyJVMTest_16510 {

    static String processTrapScriptParam1Param1 = "N8ik<v![<\\";

    static String processTrapScriptParam1Param2 = "-X!U=zz.*i";

    static String processTrapScriptParam1Param3 = "X:?iHDj8]w";

    static int processTrapScriptParam1Param4 = 164;

    static String processTrapScriptParam1Param5 = "Wc1.P'yL{g";

    static String processTrapScriptParam1Param6 = "CqsDEcE4n@";

    static String processTrapScriptParam1Param7 = "YhQg<lrL2h";

    static URI processTrapScriptParam1 = new URI(processTrapScriptParam1Param1, processTrapScriptParam1Param2, processTrapScriptParam1Param3, processTrapScriptParam1Param4, processTrapScriptParam1Param5, processTrapScriptParam1Param6, processTrapScriptParam1Param7);

    static File processTrapScript = new File(processTrapScriptParam1);

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
        new MyJVMTest_16510().createScript(processTrapScript);
    }
}
