import java.security.*;
import java.security.spec.*;

public class MyJVMTest_4556 {

    static String specParam1 = "U8AqdrVPt:";

    static String specParam2 = " \"L{tae:<6";

    static AlgorithmParameterSpec specParam3 = null;

    static int specParam4 = 23;

    static int specParam5 = 795;

    static PSSParameterSpec spec = new PSSParameterSpec(specParam1, specParam2, specParam3, specParam4, specParam5);

    static String spec2Param1 = "F`o5[+~`b(";

    static String spec2Param2 = "qEi2Q9=w=`";

    static AlgorithmParameterSpec spec2Param3 = null;

    static int spec2Param4 = 440;

    static int spec2Param5 = 265;

    static PSSParameterSpec spec2 = new PSSParameterSpec(spec2Param1, spec2Param2, spec2Param3, spec2Param4, spec2Param5);

    boolean isEqual(PSSParameterSpec spec, PSSParameterSpec spec2) throws Exception {
        if (spec == spec2)
            return true;
        if (spec == null || spec2 == null)
            return false;
        if (!spec.getDigestAlgorithm().equals(spec2.getDigestAlgorithm())) {
            System.out.println("Different digest algorithms: " + spec.getDigestAlgorithm() + " vs " + spec2.getDigestAlgorithm());
            return false;
        }
        if (!spec.getMGFAlgorithm().equals(spec2.getMGFAlgorithm())) {
            System.out.println("Different MGF algorithms: " + spec.getMGFAlgorithm() + " vs " + spec2.getMGFAlgorithm());
            return false;
        }
        if (spec.getSaltLength() != spec2.getSaltLength()) {
            System.out.println("Different Salt Length: " + spec.getSaltLength() + " vs " + spec2.getSaltLength());
            return false;
        }
        if (spec.getTrailerField() != spec2.getTrailerField()) {
            System.out.println("Different TrailerField: " + spec.getTrailerField() + " vs " + spec2.getTrailerField());
            return false;
        }
        AlgorithmParameterSpec mgfParams = spec.getMGFParameters();
        AlgorithmParameterSpec mgfParams2 = spec2.getMGFParameters();
        if (mgfParams == mgfParams2)
            return true;
        if (mgfParams == null || mgfParams2 == null) {
            System.out.println("Different MGF Parameters: " + mgfParams + " vs " + mgfParams2);
            return false;
        }
        if (mgfParams instanceof MGF1ParameterSpec) {
            if (mgfParams2 instanceof MGF1ParameterSpec) {
                boolean result = ((MGF1ParameterSpec) mgfParams).getDigestAlgorithm().equals(((MGF1ParameterSpec) mgfParams2).getDigestAlgorithm());
                if (!result) {
                    System.out.println("Different Digest algo in MGF Parameters: " + ((MGF1ParameterSpec) mgfParams).getDigestAlgorithm() + " vs " + ((MGF1ParameterSpec) mgfParams2).getDigestAlgorithm());
                }
                return result;
            } else {
                System.out.println("Different MGF Parameters types: " + mgfParams.getClass() + " vs " + mgfParams2.getClass());
                return false;
            }
        }
        throw new RuntimeException("Unrecognized MGFParameters: " + mgfParams);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4556().isEqual(spec, spec2));
    }
}
