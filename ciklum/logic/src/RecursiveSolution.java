import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveSolution {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        RecursiveSolution recursiveSolution = new RecursiveSolution();
        String line;
        try {
            while (!(line=reader.readLine()).equals("exit")){
                System.out.println(recursiveSolution.replaceSmile(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String replaceSmile(String text) {
        char result[] = text.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == ')') {
                removeSmile(result, i + 1);
            }
        }
        return String.valueOf(result);
    }

    private char[] removeSmile(char[] text, int start) {

        if (start > text.length - 1)
            return text;

        if (text[start] == ')') {
            text = removeSmile(text, start + 1);
            text[start] = 0;
        }

        return text;
    }


}
