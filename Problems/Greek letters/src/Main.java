import java.util.*;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        LinkedList<Integer> list = new LinkedList<>(new ArrayList<>());

        ArrayList<Integer> list = new ArrayList<>();

        LinkedList<Integer> list = new ArrayList<>();
    }

    static class GreekLetter {

        private String letter;
        private Integer position;

        public GreekLetter(String letter, Integer position) {
            this.letter = letter;
            this.position = position;
        }

        @Override
        public String toString() {
            return "{" +
                    "letter='" + letter + '\'' +
                    ", position=" + position +
                    '}';
        }
    }
}