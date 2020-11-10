import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int res = 0;
        for (int i = 0; i < l; i++) {
            int num = scanner.nextInt();
            if (num % 4 ==0 && num > res){
                res = num;
            }
        }
        System.out.println(res);
        // put your code here
    }
}