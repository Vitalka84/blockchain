import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> knowWords = new HashSet<>();
        Set<String> textForCheck = new HashSet<>();

        int d = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < d; i++) {
            knowWords.add(scanner.nextLine());
        }
        
        int l = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < l; i++) {
            textForCheck.addAll(Arrays.asList(scanner.nextLine().split("\\s")));
        }
        System.out.println(String.join("\n", spellChecker(knowWords, textForCheck)));
        // put your code here
    }

    static Set<String> spellChecker(Set<String> dictionary, Set<String> text) {
        Set<String> res = new HashSet<>(text.stream().map(String::toLowerCase).collect(Collectors.toList()));
        res.removeAll(dictionary.stream().map(String::toLowerCase).collect(Collectors.toList()));
        return res;
    }
}