import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        String pass = "";
        try {
            URL url = new URL(st);
            String[] param = url.getQuery().split("&");
            for (int i = 0; i < param.length; i++) {
                String[] p = param[i].split("=");
                if (p[0].equals("pass")) {
                    pass = p[p.length - 1];
                }
                System.out.print(p[0] + " : ");
                System.out.println(p.length == 1 ? "not found" : p[p.length - 1]);
            }
            if (!pass.equals("")) {
                System.out.println("password : " + pass);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // put your code here
    }
}