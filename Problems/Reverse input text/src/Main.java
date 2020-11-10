import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        char[] arr = new char[50];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.read(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != '\u0000') {
                System.out.print(arr[i]);
            }
        }

//        String input;
//        input = reader.readLine();
//        System.out.println(input);
//        int current = reader.read();
//        while (current != -1 && current != ) {
//            System.out.println("ccc: " + (char) current);
//            current = reader.read();
//        }
        // start coding here
        reader.close();
    }
}