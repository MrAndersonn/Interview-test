import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoopSolution {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        LoopSolution recursiveSolution = new LoopSolution();
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
        char[] textCharter= text.toCharArray();
        for (int i = 0; i < textCharter.length; i++) {
            if (textCharter[i]==')'){
                for (int j = i+1; j <textCharter.length; j++) {
                    if (textCharter[j]==')')
                        textCharter[j]=0;
                    else {
                        i=j;
                        break;
                    }
                }
            }
        }
        return String.valueOf(textCharter);
    }
}
