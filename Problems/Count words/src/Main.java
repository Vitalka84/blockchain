import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String trim = input.trim();
        if (trim.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(trim.split("\\s+").length);
        }
        // start coding here
        reader.close();
    }
}