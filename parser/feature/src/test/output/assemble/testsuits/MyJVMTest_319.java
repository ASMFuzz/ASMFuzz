public class MyJVMTest_319 {

    static String string = ">~p{\\#LeCu";

    static String[] array = { ":+X==1e}yA", "2v64d'{RW\"", "aw<wMK=IsI", "5 v3/Q7<Wg", "qmHr\"*w?Jn", "Y8jedXoH1&", "bWkKq_-@z$", "}HIo[b{K,~", ";xD!d~bjUt", "zD=@|!Jf(#" };

    static int _fCreationYear = -1900613457;

    int parse(String string, String[] array) {
        string = string.toLowerCase();
        for (int i = 0, alength = array.length, slength = string.length(); i < alength; i++) if (array[i].startsWith(string, 0))
            return i;
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_319().parse(string, array));
    }
}
