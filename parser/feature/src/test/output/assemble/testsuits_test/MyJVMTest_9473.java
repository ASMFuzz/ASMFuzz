public class MyJVMTest_9473 {

    static String string = "F>ZVtg=<\"#";

    static String[] array = { "D[<3}O/X[P", "|ltAmlwG*l", ".QOC:OGcI2", "?Yu'7i,?G}", "3:k}u^_-@@", "C\\*zo}as:)", "@vb28^Q;9}", "NxN/S_l;YA", "6]Q1)<:sDj", "6''9=`f2@8" };

    static int _fCreationYear = 151473269;

    int parse(String string, String[] array) {
        string = string.toLowerCase();
        for (int i = 0, alength = array.length, slength = string.length(); i < alength; i++) if (array[i].startsWith(string, 0))
            return i;
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9473().parse(string, array));
    }
}
