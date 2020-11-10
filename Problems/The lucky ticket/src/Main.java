import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        char[] array = st.toCharArray();
        int f1 = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < 3) {
                f1 = f1 + Character.getNumericValue(array[i]);
            } else {
                f1 = f1 - Character.getNumericValue(array[i]);
            }
        }
        System.out.println(f1 == 0 ? "Lucky" : "Regular");
        // put your code here
    }
}