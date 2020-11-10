import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        char[] in = st.toCharArray();
        String regx = "aeiouy";
        int vowels_sequence = 0;
        int no_vowels_sequence = 0;
        int res = 0;

        for (int i = 0; i < in.length; i++) {
            if (regx.indexOf(in[i]) >= 0) {
                if (vowels_sequence == 2){
                    res++;
                    vowels_sequence = 0;
                }
                vowels_sequence++;
                no_vowels_sequence = 0;

            } else {
                if (no_vowels_sequence == 2){
                    res++;
                    no_vowels_sequence = 0;
                }
                no_vowels_sequence++;
                vowels_sequence = 0;
            }
        }
        System.out.println(res);
        // write your code here
    }
}