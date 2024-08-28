public class MyJVMTest_7971 {

    static int b = 1;

    static short[] index1 = {32767,-32768,-29062,-6572,0,-25934,32767,-7219,0,32767};

    static String[] index2 = {"g;lcK\"ZtUg","o=j0Qj/tQk","AbV[eNwt61",")M]A2 !,v}","$zb kwWw{/","`79kDJ7a#(","u3<FPAlk\\E","oW9#iwodu6","\\;)t!Rhl\"5","4^qdz{sk#I"};

    static int start = 5;

    static int end = 0;

    static char REPLACE_CHAR = '\uFFFD';

    char decodeSingle(int b) {
        if (b >= 0)
            return (char) b;
        return REPLACE_CHAR;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7971().decodeSingle(b));
    }
}
