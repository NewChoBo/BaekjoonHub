import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    /**
     * 학생 번호 중복되지 않음
     * 학생의 번호, 학생이 좋아하는 학생 4명의 번호가 한 줄에 하나씩, 선생님이 자리를 정할 순서대로
     * 좋아하는 학생 중복 X
     * 자기 자신을 좋아하는 경우는 없음
     * 배치 위치 시작은 1, 1(좌측 상단) 끝은 N,N(우측 하단)
     * <p>
     * 자리 배치 방법
     * 1. 비어있는 칸 중, 좋아하는 학생이 가장 많이 인접한 칸 (|r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸이 (r1, c1)과 (r2, c2)를 인접)
     * 2. 동일한 경우, 인접한 칸 중 비어있는 칸이 가장 많은 칸으로 자리
     * 3. 이 역시 동일할 경우, 행의 번호가 가장 작은 칸. 이 역시 여러개인 경우, 열의 번호가 가장 작은 칸
     */

    static int N;
    static Student[][] map;
    static List<Student> studentList;

    public static void main(String[] args) throws IOException {
        init();

        for (Student student : studentList) {
            Preference preference = null;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] != null) continue;
                    Preference newPreference = student.checkPreference(i, j);
                    if (preference == null || (newPreference.studentsLike > preference.studentsLike) || (newPreference.studentsLike == preference.studentsLike && newPreference.emptySpace > preference.emptySpace)) {
                        preference = newPreference;
                    }
                }
            }
            map[preference.x][preference.y] = student;
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Student student = map[i][j];
                Preference preference = student.checkPreference(i, j);

                switch (preference.studentsLike) {
                    case 4:
                        sum += 1000;
                        break;
                    case 3:
                        sum += 100;
                        break;
                    case 2:
                        sum += 10;
                        break;
                    default:
                        sum += preference.studentsLike;
                }
            }
        }
        System.out.println(sum);
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new Student[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new Student[N];
        }
        studentList = new ArrayList<>();
        for (int i = 0; i < Math.pow(N, 2); i++) {
            studentList.add(new Student(br.readLine()));
        }
    }

    static class Student {
        int studentNo;
        Set<Integer> preferStudents = new HashSet<>();

        static final int[][] mover = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        Student(String input) {
            int[] numbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            this.studentNo = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                this.preferStudents.add(numbers[i]);
            }
        }

        Preference checkPreference(int x, int y) {
            int studentsLike = 0;
            int emptySpace = 0;

            for (int[] move : mover) {
                int newX = x + move[0];
                int newY = y + move[1];
                if (validPoint(newX, newY)) {
                    if (map[newX][newY] == null) emptySpace++;
                    else if (preferStudents.contains(map[newX][newY].studentNo)) studentsLike++;
                }
            }
            return new Preference(x, y, studentsLike, emptySpace);
        }

        boolean validPoint(int x, int y) {
            if (x < 0 || y < 0 || x >= N || y >= N) return false;
            return true;
        }
    }

    static class Preference {
        int x, y;
        int studentsLike;
        int emptySpace;

        Preference(int x, int y, int studentsLike, int emptySpace) {
            this.x = x;
            this.y = y;
            this.studentsLike = studentsLike;
            this.emptySpace = emptySpace;
        }
    }
}