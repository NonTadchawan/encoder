package th.co.geniustre.intern.unicode;


public class UTF8Decoder {
    public String decode(byte[] utf8s) {
        StringBuilder sb = new StringBuilder();
        final int STARTER_THREE = 0b1110_0000;
        final int MARK_START_THREE = 0b0000_1111;
        final int MARK_FOLLOW = 0b0011_1111;
        Integer result = 0;
        Integer prev = 0;
        int i = 0;
        while (true) {
            if (STARTER_THREE == (STARTER_THREE & utf8s[i])) {
                prev = utf8s[i] & MARK_START_THREE;
                result = result + (prev << 12);
                prev = utf8s[i + 1] & MARK_FOLLOW;
                result = result + (prev << 6);
                prev = utf8s[i + 2] & MARK_FOLLOW;
                result = result + (prev);
                sb.append(Character.toChars(result));
                result = 0;
            }
            i++;
            if (i == utf8s.length - 1) {
                break;
            }
        }
        return sb.toString();
    }
}
