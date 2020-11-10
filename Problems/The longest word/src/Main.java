import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\s+");
        String res = "";
        for (int i = 0; i < array.length; i++) {
            if (res.length() < array[i].length()){
                res = array[i];
            }
        }
        System.out.println(res);
        // put your code here
    }
}