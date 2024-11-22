package DSA.Hw6_22000123_NguyenDucSi.bai_tap_5;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    // Encodes a URL to a shortened URL.

    static Map<String, String> map = new HashMap<>();
    static int count = 0;

    public String encode(String longUrl) {
        String encoded = "http://tinyurl.com/" + count;
        map.put(encoded, longUrl);
        count++;
        return encoded;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
