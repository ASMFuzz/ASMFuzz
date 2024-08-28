public class MyJVMTest_17515 {

    static String s = "9C/E!XrlsY";

    static String[] a = { "Icv#f+ZMf1", "ebrgpT>MF8", "BWtB/=Sv5l", "=|?$IS_VXq", "Y2M|\\?u_i{", "N3VCv)Cg8n", "OiQA)~?)H/", "I\"Vd9LZfPu", "%> >Vz~=(G", "(D:hLpr'9'" };

    boolean isPresent(String s, String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
            if (s.equals(a[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17515().isPresent(s, a));
    }
}
