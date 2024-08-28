import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;

public class MyJVMTest_3333 {

    static AlgorithmParametersSpi paramParam1 = null;

    static String paramParam2Param1 = "<^q_nTdJge";

    static double paramParam2Param2 = Double.NEGATIVE_INFINITY;

    static String paramParam2Param3 = "BwVI[\"A)f~";

    static Provider paramParam2 = new AuthProvider(paramParam2Param1, paramParam2Param2, paramParam2Param3);

    static String paramParam3 = " )LF1MG8AH";

    static AlgorithmParameters param = new AlgorithmParameters(paramParam1, paramParam2, paramParam3);

    static int genParamParam1 = 315;

    static int genParamParam2 = 92;

    static DSAGenParameterSpec genParam = new DSAGenParameterSpec(genParamParam1, genParamParam2);

    int checkParamStrength(AlgorithmParameters param, DSAGenParameterSpec genParam) throws Exception {
        String algo = param.getAlgorithm();
        if (!algo.equalsIgnoreCase("DSA")) {
            throw new Exception("Unexpected type of parameters: " + algo);
        }
        DSAParameterSpec spec = param.getParameterSpec(DSAParameterSpec.class);
        int valueL = spec.getP().bitLength();
        int strength = genParam.getPrimePLength();
        if (strength != valueL) {
            System.out.println("P: Expected " + strength + " but actual " + valueL);
            throw new Exception("Wrong P strength");
        }
        int valueN = spec.getQ().bitLength();
        strength = genParam.getSubprimeQLength();
        if (strength != valueN) {
            System.out.println("Q: Expected " + strength + " but actual " + valueN);
            throw new Exception("Wrong Q strength");
        }
        return strength;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3333().checkParamStrength(param, genParam);
    }
}
