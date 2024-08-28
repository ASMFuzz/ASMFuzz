import java.security.*;
import java.security.spec.*;

public class MyJVMTest_2410 {

    static int specParam1 = 189;

    static PSSParameterSpec spec = new PSSParameterSpec(specParam1);

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

    static String PROVIDER = "SunRsaSign";

    static String PSS_ALGO = "RSASSA-PSS";

    static String PSS_OID = "1.2.840.113549.1.1.10";

    String test(PSSParameterSpec spec) throws Exception {
        String[] ALGORITHMS = { PSS_ALGO, PSS_OID };
        for (String alg : ALGORITHMS) {
            AlgorithmParameters params = AlgorithmParameters.getInstance(alg, PROVIDER);
            params.init(spec);
            byte[] encoded = params.getEncoded();
            AlgorithmParameters params2 = AlgorithmParameters.getInstance(alg, PROVIDER);
            params2.init(encoded);
            PSSParameterSpec spec2 = params2.getParameterSpec(PSSParameterSpec.class);
            if (!isEqual(spec, spec2)) {
                throw new RuntimeException("Spec check Failed for " + alg);
            }
        }
        return alg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2410().test(spec);
    }
}
