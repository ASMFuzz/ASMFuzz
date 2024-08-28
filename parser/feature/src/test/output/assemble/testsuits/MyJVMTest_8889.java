import java.io.*;
import java.util.*;
import java.security.*;
import java.security.interfaces.*;
import java.security.spec.*;

public class MyJVMTest_8889 {

    static String PKCS1_PRIV_STR = "MIIEowIBAAKCAQEA0OIArlYES4X1XMTLDordtN/XIWFE1wvhl40RsHWM2n99+Stp" + "CCJCcUb5FJ2/kefj/XRwB6p5IMpIZrHZqC8XXzlX5fpiFaSu2xnk17oWUKoErW27" + "Stm098pU2RoUxWPKVl+42a8iVp8tijNElBNFALCGi0zXOhcTxMh0q1Wk0UhMJqam" + "v5YnCKmT4THwwGYn/KeK3M7Qa+o5MoVBHLbeT9LJgEmSluVzIh44Lh6weX0bw72P" + "8X2praOhbzg2B343MqS/rMLw6On+0i7ccEgp23vX9G5w85q4A5FSIrk4S/pyv5sO" + "rwjCQKBW1TS0/2iB9zNkFMj5/+h7l2oqTT7sSQIDAQABAoIBADn6sXOynoiUC1IP" + "sck8lGOTSjSSujfyrVCSsJlJV6qCfuX9va6rS8QDjjnBu531PtxoSHxoPizy2Pvg" + "W+kKATPGR/am9DjLuFlKq7GRjoYfWyMEdVtGaKvq9ng4fBF6LHyjHz0VFrPyhQJ6" + "TovHeXzCguYBkzAlnbAeb/vqzs/kABbOuSHVi7DsaixCoEX9zOptFYQw/l8rh68+" + "UF2bpNNH3jOC1uN3vZtuSwCupqtN+2Mpkx2h04Rk75vWIhrnPeMgmcd3yP4LNZMR" + "mfaynb63RRzVkNis7+NVk016SQ1oL79mrBvy5rBg3HeCeArwvqZAmOaWsLSWHzCy" + "zlVlMTECgYEA6JlnMpC956Qi8HX5ye4Hu2ovBdbNGtH/TMkZmColJz9P7CvNkNIb" + "Od6mvLMydbPHkhdBUDWD4rhiCKHrf5zKju1i24YqWcvuSGotWj4/KQ3+87mLZM+7" + "daBsJBmSEVB80sgA9ItqSgOyNoNFpiDgFnlszAfb0n9XXEzB/pwSw1UCgYEA5eXI" + "d+eKugugP+n6CluQfyxfN6WWCzfqWToCTTxPn2i12AiEssXy+kyLjupJVLWSivdo" + "83wD5LuxFRGc9P+aKQERPhb0AFaxf1llUCXla65/x2So5xjMvtuzgQ0OktPJqJXq" + "hYGunctsr5rje33+7vlx4xWkrL2PrQWzJabn7SUCgYEAqw3FesY/Ik7u8u+P1xSZ" + "0xXvptek1oiAu7NYgzLbR9WjrQc5kbsyEojPDg6qmSyxI5q+iYIRj3YRgk+xpJNl" + "0154SQCNvKPghJiw6aDFSifkytA01tp9/a8QWCwF433RjiFPsoekjvHQ6Y34dofO" + "xDhf7lwJKPBFCrfYIqocklECgYAIPI9OHHGP8NKw94UJ0fX/WGug5sHVbQ9sWvOy" + "KLMBlxLMxqFadlUaOpvVZvdxnX++ktajwpGxJDhX9OWWsYGobm1buB7N1E1Prrg+" + "gt0RWpMhZa3Xeb/8Jorr2Lfo8sWK0LQyTE8hQCSIthfoWL9FeJJn/GKF/dSj8kxU" + "0QIGMQKBgG/8U/zZ87DzfXS81P1p+CmH474wmou4KD2/zXp/lDR9+dlIUeijlIbU" + "P6Y5xJvT33Y40giW9irShgDHjZgw0ap11K3b2HzLImdPEaBiENo735rpLs8WLK9H" + "+yeRbiP2y9To7sTihm9Jrkctzp6sqFtKyye1+S21X1tMz8NGfXen";

    static PrivateKey P1_PRIV = null;

    String getFormat() {
        return "PKCS#1";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8889().getFormat());
    }
}
