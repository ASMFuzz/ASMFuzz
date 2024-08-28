public class MyJVMTest_3956 {

    static String val = "v3Gh!(;+xq";

    static float n = Float.NEGATIVE_INFINITY;

    static String[] badStrings = { "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "\u0661e\u0661", "\u06F1e\u06F1", "\u0967e\u0967" };

    static String[] goodStrings = { "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810" };

    static String[] paddedBadStrings = {"&(^{BL49i(","qTMzT0WS*s","EW'B//yAlI","bM!qlV&f{+","64ie3bGwKq","PK<f'5bu9Z","W?MA*0m:]d","l/BC5yX~rG","!$-OTcd)Ms","Kn(2DBkkLF"};

    static String[] paddedGoodStrings = {"7?!X^1]u^7","'Mw\"<*r/Z_","4& qY^#t|X","ceI;UrH}C4","j~wcN7OyvG","s\",IzHzybE","dt%^nE{|sT","(@GNnS~%M3","q/:iJ?$%%x","r+pGR.2ISS"};

    float fail(String val, float n) {
        throw new RuntimeException("Float.parseFloat failed. String:" + val + " Result:" + n);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3956().fail(val, n);
    }
}
