public class MyJVMTest_10767 {

    static String[] args = { ",>EBos6S< ", "5g!%rPW*3\"", "VlVYAtWi%*", "1[|ml-},5M", "}VcBp45Wg!", "~/n*c],9is", "wjWj%>~FiK", "/o-C}N%MU&", "Dev?IjKwT?", "88W+?\"sk\\_" };

    static char v = Character.MIN_VALUE;

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
        System.out.println(new MyJVMTest_10767().initChar(args, v));
    }
}
