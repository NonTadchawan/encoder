package th.co.geniustre.intern.unicode;


public class UTF8Decoder {
    public String decode(byte[] utf8s) {
        Unicode unicode = new Unicode();
        StringBuilder sb = new StringBuilder();
        final Integer test1 = 0b1110_0000;
        final Integer test2 = 0b1000_0000;
        Integer[] ints = {};
        Integer result = 0;
        Integer prev = 0;

        for (int i = 0; i < utf8s.length; i++) {
            if (test1.equals(test1 & utf8s[i])) {
                ints = new Integer[utf8s.length];
                prev = utf8s[i] & (0b0000_1111);
                ints[i] = prev << 12;
            } else if (test2.equals(test2 & utf8s[i])) {
                int i1 = utf8s[i] & (0b0011_1111);
                if (prev < 15) {
                    ints[i] = i1 << 6;
                } else {
                    ints[i] = i1;
                }
                prev = i1;
            }
            result = result + ints[i];
            if ((i + 1) % 3 == 0) {
                String st = unicode.getUnicodeChars().get(result).toString();
                sb.append(st);
                result = 0;
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}
