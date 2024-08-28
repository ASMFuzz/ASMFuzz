public class MyJVMTest_17535 {

    static int b = 6;

    static short[] index1 = {32767,0,13895,-13193,32767,32767,12945,32767,-32768,-32768};

    static String[] index2 = {"Z^~siz6%j:","FV}]v94)}W","aPphoKN'W ","(W`]'A2}Z-","xaH'<)F[2R","O\\NqmlNaDu","0+BI[6g\\}p","9Te7oG-:e%",":9Vb-5?H=^","J}E+lWgaL9"};

    static int start = 0;

    static int end = 7;

    static char REPLACE_CHAR = '\uFFFD';

    char decodeSingle(int b) {
        if (b >= 0)
            return (char) b;
        return REPLACE_CHAR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17535().decodeSingle(b));
    }
}
