import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // !@#$%^&*()-+
    public static void main(String[] args) throws IOException {
        // 비밀번호는 6글자 이상
        // 숫자는 하나 이상 포함
        // 알파벳 소문자 하나 이상
        // 알파벳 대문자 하나 이상
        // 특수문자 하나 이상
        boolean containNum = false;
        boolean containLowerCase = false;
        boolean containUpperCase = false;
        boolean containSpecialChar = false;

        int passwordLength = Integer.parseInt(br.readLine());
        String passWord = br.readLine();
        Set<Character> characterSet = new HashSet<>();
        characterSet.add('!');
        characterSet.add('@');
        characterSet.add('#');
        characterSet.add('$');
        characterSet.add('%');
        characterSet.add('^');
        characterSet.add('&');
        characterSet.add('*');
        characterSet.add('(');
        characterSet.add(')');
        characterSet.add('-');
        characterSet.add('+');

        int cnt = 0;

        for (char c : passWord.toCharArray()) {
            if (!containNum && c - '0' >= 0 && '9' - c >= 0) {
                containNum = true;
            } else if (!containLowerCase && c - 'a' >= 0 && 'z' - c >= 0) {
                containLowerCase = true;
            } else if (!containUpperCase && c - 'A' >= 0 && 'Z' - c >= 0) {
                containUpperCase = true;
            } else if (!containSpecialChar && characterSet.contains(c)) {
                containSpecialChar = true;
            }
        }

        if(!containNum) cnt++;
        if(!containLowerCase) cnt++;
        if(!containUpperCase) cnt++;
        if(!containSpecialChar) cnt++;

        if (passwordLength + cnt < 6) {
            System.out.println(6 - passwordLength);
        } else {
            System.out.println(cnt);
        }
    }
}