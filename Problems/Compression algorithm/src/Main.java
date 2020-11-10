import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.next().toCharArray();
        StringBuilder output = new StringBuilder().append(input[0]);
        int l = 1;
        if (input.length == 1) {
            output.append(l);
        }
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                l++;
            } else {
                output.append(l);
                output.append(input[i]);
                l = 1;
            }
            if (i == input.length - 1) {
                output.append(l);
            }
        }
        System.out.println(output.toString());
        // put your code here
    }
}