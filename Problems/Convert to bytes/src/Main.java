import java.io.InputStream;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        String st = scanner.nextLine();
        char[] arr = st.toCharArray();
        for (char c : arr) {
            System.out.print((byte) c);
        }
    }
}