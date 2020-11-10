import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        char[] array = st.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(array[i]);
            }
        }
        // put your code here
    }
}