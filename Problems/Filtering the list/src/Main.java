import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        IntStream input = Arrays.stream(Arrays.stream(str.split("\\s")).mapToInt(Integer::parseInt).toArray());
        List<Integer> list = input.boxed().collect(Collectors.toList());
        int remFlag = 1;
        List<Integer> newList = new ArrayList<>();
        for (Integer integer : list) {
            if (remFlag == 1) {
                remFlag = 0;
            } else {
                newList.add(integer);
                remFlag = 1;
            }
        }
        Collections.reverse(newList);
        for (Integer integer : newList) {
            System.out.print(integer + " ");
        }
        // put your code here
    }
}