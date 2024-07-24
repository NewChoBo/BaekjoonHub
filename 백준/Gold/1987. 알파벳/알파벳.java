import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	static int[][] arr;
	static int R;
	static int C;
	static int result = 0;
	static boolean alpha[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		alpha = new boolean[26];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		
		visited = new boolean[R][C];
		visited[0][0] = true;
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			
			for(int j=0; j<C; j++) {
				arr[i][j] = line.charAt(j)-'A';
			}
		}
		alpha[arr[0][0]] = true;
		dfs(0,0,1);
		
		sb.append(result);
		
		System.out.println(sb.toString());
		br.close();

	}
	private static void dfs(int x, int y, int cnt) {
		
		result = Math.max(result, cnt);
		
		
		for(int k=0; k<4; k++) {
			
			int nx = dx[k] + x;
			int ny = dy[k] + y;
			
			if(nx >= R || ny>= C || nx<0 || ny <0 || visited[nx][ny] || alpha[arr[nx][ny]] ) {
				continue;
			}
			visited[nx][ny] = true;
			alpha[arr[nx][ny]] = true;
			dfs(nx, ny, cnt+1);
			
			visited[nx][ny] = false;
			alpha[arr[nx][ny]] = false;
		}
		
	}

}
