import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input
    List<String> out = new ArrayList<>();
    boolean isFinished = false;
    String newLine;

    @Override
    public void run() {
        while (!isFinished) {
            newLine = scanner.nextLine();
            if (newLine != newLine.toUpperCase()) {
                out.add(newLine.toUpperCase());
            } else {
                out.add("FINISHED");
                isFinished = true;
            }
        }
        out.stream().forEach(System.out::println);
        // implement this method
    }
}
