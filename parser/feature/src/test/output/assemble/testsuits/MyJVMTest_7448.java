public class MyJVMTest_7448 {

    static String launchName = "L-p1-]KE<q";

    static String launchMode = "**%Y#RtRnf";

    static String[] args = { "%Z\"r;>etGa", "=EpJrjUV(L", "mFqK?hR`l$", "vCBA--~%#$", "Qexi7lkcJT", "\"iOCvL{5uy", "KWaYe&Nj(\"", "<-[&,huc45", "'au|mpL6Lf", "m:P&@e&][#" };

    String launchApplication(final String launchName, final String launchMode, final String[] args) {
        System.out.println("LaunchName: " + launchName);
        System.out.println("LaunchMode: " + launchMode);
        System.out.println("Parameters:");
        for (String arg : args) {
            System.out.println("parameter: " + arg);
        }
        System.exit(0);
        return launchMode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7448().launchApplication(launchName, launchMode, args);
    }
}
