public class MyJVMTest_4559 {

    static String[] args = { "AU[HO7nSG*", "rmigQiLTFc", "p\\pSN)SM|o", "AP3Wt=J#Wb", "As1d[rV'>3", "d7<C2WWC<]", "CXwZ*I5<& ", "{ltm2)Pnd9", "OA 3 P91tM", "%^^VJIxQ\"n" };

    static String match = "DDd5Uo]w$!";

    boolean _match(String[] args, String match) {
        boolean toRet = false;
        for (int i = 0; !toRet && (i < args.length); i++) {
            toRet = match.equals(args[i]);
        }
        return toRet;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4559()._match(args, match));
    }
}
