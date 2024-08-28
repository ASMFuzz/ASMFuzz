public class MyJVMTest_7335 {

    static String suffix = ";F\\7b]cys*";

    static String[] types = { "oM 8atq^me", ":zmD\"uM1%j", ";}d&20[y#V", ")M`g|De&\\`", "dL.3QmW~Jz", "wTk2p(TIhf", "&&QgqB0RlT", "B_mKpu-J2#", "xs)E{L\\i4G", "';2sHUBXX9" };

    String selectCompressionType(final String suffix, final String[] types) {
        switch(suffix) {
            case "tif":
            case "tiff":
                return "LZW";
            default:
                return types[0];
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7335().selectCompressionType(suffix, types));
    }
}
