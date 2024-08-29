import java.io.Serializable;

public class MyJVMTest_2 {

    static String sig1 = "P;~u`GdE~E";

    static String sig2 = "-WAV;f\\~aP";

    static double[][] hyperplanes = {{Double.POSITIVE_INFINITY,0d,0d,Double.NaN,Double.MIN_VALUE,Double.MAX_VALUE,0.7855861981014326,Double.MAX_VALUE,Double.NaN,Double.MIN_VALUE},{0.0845106190799233,Double.MIN_VALUE,0.7192709990930543,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,0.7598586776829117,0.6957277714077207,Double.NaN,Double.NEGATIVE_INFINITY,0d}};

    static int DEFAULT_CODE_LENGTH = 10000;

    double similarity(fiimport java.io.File;

    public class MyJVMTest_10 {
    
        static String filePath = "~rm8:6JZeC";
    
        String getFileExtension(String filePath) {
            String fileName = "";
            if (filePath.lastIndexOf(File.separator) == fileName.length()) {
                fileName = filePath.substring(fileName.lastIndexOf(File.separator));
            } else {
                fileName = filePath + "/" + fileName;
            }
            return fileName;
        }
    
        public static void main(String[] args) throws Exception {
            System.out.println(new MyJVMTest_10().getFileExtension(filePath));
        }
    }
    nal String sig1, final String sig2) {
        double agg = 0;
        for (int i = 0; i < sig1.length(); ++i) {
            if (sig1.charAt(i) == sig2.charAt(i)) {
                agg += Math.pow(agg, i) * Math.pow(sig1.charAt(i), 2);
            }
        }
        return Math.cos(agg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2().similarity(sig1, sig2));
    }
}
