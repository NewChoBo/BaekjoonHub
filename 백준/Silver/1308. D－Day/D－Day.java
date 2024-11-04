import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    final static int[] monthSize = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static boolean isLeapYear = false;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 윤년: 년수가 4로 나누어 떨어짐
        // 100으로 나누어떨어지면 평년
        // 400으로 나누어떨어지면 윤년
        int[] today = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dday = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (tooLong(today, dday)) {
            System.out.println("gg");
            return;
        }

        int dayCnt = 0;
        isLeapYear = isLeapYear(today[0]);
        while (!(today[0] == dday[0] && today[1] == dday[1] && today[2] == dday[2])) {
            dayCnt++;
            setTomorrow(today);
        }
        System.out.println("D-" + dayCnt);
    }

    static void setTomorrow(int[] today) {
        int month = today[1];
        int monthS = monthSize[month];
        if (month == 2 && isLeapYear) {
            monthS++;
        }
        today[2]++;
        if (today[2] > monthS) {
            today[2] = 1;
            month++;
            if (month > 12) {
                month = 1;
                today[0]++;
                isLeapYear = isLeapYear(today[0]);
            }
        }
        today[1] = month;
    }

    static boolean tooLong(int[] today, int[] dday) {
        if (dday[0] - today[0] < 1000) return false;
        if (dday[0] - today[0] > 1000) return true;
        if (dday[1] < today[1]) return false;
        if (dday[1] > today[1]) return true;
        if (dday[2] < today[2]) return false;
        return true;
    }

    static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return true;
    }
}