import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine().toLowerCase();
        char[] array = st.toCharArray();
        int cgCount = 0;
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'c' || array[i] == 'g') {
                cgCount++;
            }
        }
        if (cgCount > 0) {
            result = (double) cgCount / array.length * 100;
        }
        System.out.println(result);
        // put your code here
    }
}