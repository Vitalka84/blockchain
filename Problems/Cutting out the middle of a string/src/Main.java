import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        boolean isOdd = st.length() % 2 == 0 ? true : false;
        StringBuffer sb = new StringBuffer();
        sb.append(st, 0, isOdd ? st.length() / 2 - 1 : st.length() / 2);
        sb.append(st, st.length() / 2 + 1, st.length());
        System.out.println(sb.toString());
        // put your code here
    }
}