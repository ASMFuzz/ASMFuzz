import java.security.*;
import java.security.spec.*;

public class MyJVMTest_3855 {

    static String specParam1 = "MyJM%OU$ ~";

    static String specParam2 = "[tumD?MEqJ";

    static AlgorithmParameterSpec specParam3 = null;

    static int specParam4 = 372;

    static int specParam5 = 938;

    static PSSParameterSpec spec = new PSSParameterSpec(specParam1, specParam2, specParam3, specParam4, specParam5);

    static String spec2Param1 = ".K1`CR>*dg";

    static String spec2Param2 = "C(/SHW[qR>";

    static AlgorithmParameterSpec spec2Param3 = null;

    static int spec2Param4 = 371;

    static int spec2Param5 = 992;

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
                    System.out.println("Different MGF1 digest algorithms: " + ((MGF1ParameterSpec) mgfParams).getDigestAlgorithm() + " vs " + ((MGF1ParameterSpec) mgfParams2).getDigestAlgorithm());
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
        System.out.println(new MyJVMTest_3855().isEqual(spec, spec2));
    }
}
