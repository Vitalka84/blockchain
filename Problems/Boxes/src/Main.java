import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    box1[j] = scanner.nextInt();
                } else {
                    box2[j] = scanner.nextInt();
                }
            }
        }
        int check = compareBoxes(box1, box2);
        System.out.println(check == 1 ? "Box 1 > Box 2" : check == 2 ? "Box 1 < Box 2" : "Incompatible");
    }

    static int compareBoxes(int[] box1, int[] box2) {
        Arrays.sort(box1);
        Arrays.sort(box2);
        int check = 0;
        for (int i = 0; i < box1.length; i++) {
            if (box1[i] > box2[i]) {
                check++;
            } else if (box1[i] < box2[i]) {
                check--;
            }
        }
        return check == 3 ? 1 : check == -3 ? 2 : 3;
    }

}
