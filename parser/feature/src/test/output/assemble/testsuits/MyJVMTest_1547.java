public class MyJVMTest_1547 {

    static String[] args = { "YTn#SF]^Ek", "|(),6[{3{F", "S9f~43oZ?G", "))Pn/~(bqw", "U9CHfK|uV ", "xw.S`K^G{k", "%qsSC Km<,", "S'7G[<?|O$", "\\%{5HROY{p", "'n6u(fvT c" };

    static char v = '0';

    char initChar(String[] args, char v) {
        if (args.length > 0) {
            try {
                return (char) Integer.valueOf(args[0]).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1547().initChar(args, v));
    }
}
