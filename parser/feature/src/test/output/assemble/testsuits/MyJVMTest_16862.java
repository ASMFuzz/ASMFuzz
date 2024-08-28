public class MyJVMTest_16862 {

    static String suffix = "s\\E\"\\oG=o'";

    static String[] types = { "5Dm3@=\\NJf", "X\\4zqSPFRY", "\\q{dBxt;Qv", "ago G9LGm\\", "q@_s){bM-n", "1oMv3#{W.X", "'v#~/\"6Fq8", "4JSXhe?yjb", "VTj\"O#E*!=", "z!5/a9lib)" };

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
        System.out.println(new MyJVMTest_16862().selectCompressionType(suffix, types));
    }
}
