import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
        }
        return sb.toString().toCharArray();
        // implement the method
    }
}