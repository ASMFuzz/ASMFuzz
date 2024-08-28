public class MyJVMTest_9906 {

    static String[] values = {"p]z7$am<]?","r<'AoEhMFb","RT!Qs\"%5o/","tFDe(~@]|U","`AVa/^Z>[,","Rb5#T<X3[/","J2\"Vp5yp&8"," a~28/'vw]","wT?(']!1qR","\"pGokYmSz@"};

    String foo() {
        int i = Integer.MAX_VALUE - 1;
        String s;
        try {
            s = values[i];
        } catch (Throwable e) {
            s = "";
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9906().foo());
    }
}
