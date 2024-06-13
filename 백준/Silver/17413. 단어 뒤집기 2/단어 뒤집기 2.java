import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        char[] S = br.readLine().toCharArray();
        int tagFlag = 0;
        Stack<Character> characterStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char c : S) {
            switch (c) {
                case ' ':
                    if(tagFlag == 0) {
                        printChars(characterStack, result);
                        result.append(c);
                        continue;
                    }
                    break;
                case '<':
                    printChars(characterStack, result);
                    tagFlag++;
                    result.append(c);
                    continue;
                case '>':
                    tagFlag--;
                    result.append(c);
                    continue;
            }
            if(tagFlag != 0) {
                result.append(c);
            } else {
                characterStack.push(c);
            }
        }
        printChars(characterStack, result);
        bw.write(result.toString());
        bw.flush();
    }

    static void printChars(Stack<Character> characterStack, StringBuilder result) {
        while (!characterStack.isEmpty()) {
            result.append(characterStack.pop());
        }
    }
}