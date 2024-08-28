public class MyJVMTest_3929 {

    static String[] args = { "0dO1]AjNt%", ")>qZpC__|!", "6(f\\S p%yo", "TK@92N/ah(", "\"3YYp]Y/?j", "NCwk=%RU`d", "rR'3#WgXEo", "':,:\\?G`DK", "E]x\".g%Prv", "?7L\"tEVy@/" };

    String[] stackMapTableTest(String[] args) {
        if (args.length > 0) {
            byte[] mat1 = new byte[] { 1, 2, 3 };
            byte[] mat2 = new byte[] { 4, 5, 6 };
            byte[] mat3 = new byte[mat1.length];
            for (int i = 0; i < mat3.length; i++) {
                mat3[i] = (byte) (mat1[i] + mat2[i]);
            }
        } else {
            boolean[] mat1 = new boolean[] { true, false };
            boolean[] mat2 = new boolean[] { false, true };
            boolean[] mat3 = new boolean[mat1.length];
            for (int i = 0; i < mat3.length; i++) {
                mat3[i] = mat1[i] | mat2[i];
            }
        }
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3929().stackMapTableTest(args);
    }
}
