import java.util.*;

public class MyJVMTest_13168 {

    static List<String> args = new ArrayList<String>();

    static Map<String, String> properties = new HashMap<String, String>();

    static TreeMap<String, String[]> optionMap = null;

    String parse(List<String> args, Map<String, String> properties) {
        String resultString = null;
        TreeMap<String, String[]> optmap = optionMap;
        ListIterator<String> argp = args.listIterator();
        ListIterator<String> pbp = new ArrayList<String>().listIterator();
        doArgs: for (; ; ) {
            String arg;
            if (pbp.hasPrevious()) {
                arg = pbp.previous();
                pbp.remove();
            } else if (argp.hasNext()) {
                arg = argp.next();
            } else {
                break doArgs;
            }
            tryOpt: for (int optlen = arg.length(); ; optlen--) {
                String opt;
                findOpt: for (; ; ) {
                    opt = arg.substring(0, optlen);
                    if (optmap.containsKey(opt)) {
                        break findOpt;
                    }
                    if (optlen == 0) {
                        break tryOpt;
                    }
                    SortedMap<String, String[]> pfxmap = optmap.headMap(opt);
                    int len = pfxmap.isEmpty() ? 0 : pfxmap.lastKey().length();
                    optlen = Math.min(len, optlen - 1);
                    opt = arg.substring(0, optlen);
                }
                opt = opt.intern();
                assert (arg.startsWith(opt));
                assert (opt.length() == optlen);
                String val = arg.substring(optlen);
                boolean didAction = false;
                boolean isError = false;
                int pbpMark = pbp.nextIndex();
                String[] specs = optmap.get(opt);
                eachSpec: for (String spec : specs) {
                    if (spec.length() == 0) {
                        continue eachSpec;
                    }
                    if (spec.startsWith("#")) {
                        break eachSpec;
                    }
                    int sidx = 0;
                    char specop = spec.charAt(sidx++);
                    boolean ok;
                    switch(specop) {
                        case '+':
                            ok = (val.length() != 0);
                            specop = spec.charAt(sidx++);
                            break;
                        case '*':
                            ok = true;
                            specop = spec.charAt(sidx++);
                            break;
                        default:
                            ok = (val.length() == 0);
                            break;
                    }
                    if (!ok) {
                        continue eachSpec;
                    }
                    String specarg = spec.substring(sidx);
                    switch(specop) {
                        case '.':
                            resultString = (specarg.length() != 0) ? specarg.intern() : opt;
                            break doArgs;
                        case '?':
                            resultString = (specarg.length() != 0) ? specarg.intern() : arg;
                            isError = true;
                            break eachSpec;
                        case '@':
                            opt = specarg.intern();
                            break;
                        case '>':
                            pbp.add(specarg + val);
                            val = "";
                            break;
                        case '!':
                            String negopt = (specarg.length() != 0) ? specarg.intern() : opt;
                            properties.remove(negopt);
                            properties.put(negopt, null);
                            didAction = true;
                            break;
                        case '$':
                            String boolval;
                            if (specarg.length() != 0) {
                                boolval = specarg;
                            } else {
                                String old = properties.get(opt);
                                if (old == null || old.length() == 0) {
                                    boolval = "1";
                                } else {
                                    boolval = "" + (1 + Integer.parseInt(old));
                                }
                            }
                            properties.put(opt, boolval);
                            didAction = true;
                            break;
                        case '=':
                        case '&':
                            boolean append = (specop == '&');
                            String strval;
                            if (pbp.hasPrevious()) {
                                strval = pbp.previous();
                                pbp.remove();
                            } else if (argp.hasNext()) {
                                strval = argp.next();
                            } else {
                                resultString = arg + " ?";
                                isError = true;
                                break eachSpec;
                            }
                            if (append) {
                                String old = properties.get(opt);
                                if (old != null) {
                                    String delim = specarg;
                                    if (delim.length() == 0) {
                                        delim = " ";
                                    }
                                    strval = old + specarg + strval;
                                }
                            }
                            properties.put(opt, strval);
                            didAction = true;
                            break;
                        default:
                            throw new RuntimeException("bad spec for " + opt + ": " + spec);
                    }
                }
                if (didAction && !isError) {
                    continue doArgs;
                }
                while (pbp.nextIndex() > pbpMark) {
                    pbp.previous();
                    pbp.remove();
                }
                if (isError) {
                    throw new IllegalArgumentException(resultString);
                }
                if (optlen == 0) {
                    break tryOpt;
                }
            }
            pbp.add(arg);
            break doArgs;
        }
        args.subList(0, argp.nextIndex()).clear();
        while (pbp.hasPrevious()) {
            args.add(0, pbp.previous());
        }
        return resultString;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13168().parse(args, properties));
    }
}
