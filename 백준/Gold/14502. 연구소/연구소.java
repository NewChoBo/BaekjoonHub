

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus{
	int x;
	int y;
	Virus(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static Queue<Virus> queue = new LinkedList<Virus>();
	static int N;
	static int M;
	static boolean visited[][];
	static int nx[] = {0,0,-1,1};
	static int ny[] = {-1,1,0,0};
	static int max = Integer.MIN_VALUE;
	static int cnt0 = 0;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt( st.nextToken() );
		M = Integer.parseInt( st.nextToken() );

		int[][] arr = new int[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, arr);
		
		System.out.println(max);
	}


	private static void dfs(int X, int arr[][]) {
		
		if(X == 3) {
			visited = new boolean[N][M];
			
			int[][] copy = new int[N][M];
			for(int i=0; i<N; i++) {
				copy[i] = arr[i].clone(); 
			}
	
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copy[i][j] == 2) {
						
						bfs(copy, i, j);
					}
					
				}
			}
			
			int cnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copy[i][j]==0) cnt++;
				}
			}
			
			max = Math.max( cnt, max );
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(X+1, arr);
					arr[i][j] = 0;
				}
			}
		}
	}


	private static void bfs(int[][] arr, int x, int y) {
		
		queue.add(new Virus(x,y));
		
		while(!queue.isEmpty()) {
			Virus v = queue.poll();
			int qx = v.x;
			int qy = v.y;
			
			for(int k=0; k<4; k++) {
				int dx = qx + nx[k];
				int dy = qy + ny[k];
				
				if(dx>=0 && dy>= 0 && dx<N && dy < M && !visited[dx][dy] && arr[dx][dy]==0) {
					visited[dx][dy] = true;
					arr[dx][dy] = 2;
					queue.add(new Virus(dx,dy));
				}
			}
		}
		
		
	}

}
