public class MyJVMTest_13305 {

    static String val = "+>$$eyZ <}";

    static float n = 0.8225194f;

    static String[] badStrings = { "", "+", "-", "+e", "-e", "+e170", "-e170", "1234   e10", "-1234   e10", "1\u0007e1", "1e\u00071", "NaNf", "NaNF", "NaNd", "NaND", "-NaNf", "-NaNF", "-NaNd", "-NaND", "+NaNf", "+NaNF", "+NaNd", "+NaND", "Infinityf", "InfinityF", "Infinityd", "InfinityD", "-Infinityf", "-InfinityF", "-Infinityd", "-InfinityD", "+Infinityf", "+InfinityF", "+Infinityd", "+InfinityD", "NaNe10", "-NaNe10", "+NaNe10", "Infinitye10", "-Infinitye10", "+Infinitye10", "\u0661e\u0661", "\u06F1e\u06F1", "\u0967e\u0967" };

    static String[] goodStrings = { "NaN", "+NaN", "-NaN", "Infinity", "+Infinity", "-Infinity", "1.1e-23f", ".1e-23f", "1e-23", "1f", "1", "2", "1234", "-1234", "+1234", "2147483647", "2147483648", "-2147483648", "-2147483649", "16777215", "16777216", "16777217", "-16777215", "-16777216", "-16777217", "9007199254740991", "9007199254740992", "9007199254740993", "-9007199254740991", "-9007199254740992", "-9007199254740993", "9223372036854775807", "9223372036854775808", "9223372036854775809", "-9223372036854775808", "-9223372036854775809", "-9223372036854775810" };

    static String[] paddedBadStrings = {"4$t[x|\\te;","%fmd`6L<3_","+|~L;e9WqA","xJC<{wnoQa","4N0%k][p<\"","=WAKfn|q~]","2,|/`Fi7\\:","\\}b*6_1&dQ","xjsz7)l-kG","N4lR+6BrGz"};

    static String[] paddedGoodStrings = {"&2WARu2sbZ","\"$!|E;i0~R","&}Tt==jGrc","yIh$-fVdZ\"","clJ%Op12xE","j8wLXNY\\k ","OFW8VWW KM","7CU|jOq/_.",")JM.5#AA~d","MrI]JMR~XI"};

    float fail(String val, float n) {
        throw new RuntimeException("Float.parseFloat failed. String:" + val + " Result:" + n);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13305().fail(val, n);
    }
}
