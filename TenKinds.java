import java.util.*;

public class TenKinds{
	public static int[][] visited;
	public static int[][][] p;


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int rowTotal = sc.nextInt();
		int colTotal = sc.nextInt();
		String nextLine = sc.nextLine();

		char[][] grid = new char[rowTotal+2][colTotal+2];
		int[][] visited = new int[rowTotal+2][colTotal+2];
		int[][] parent = new int[rowTotal+2][colTotal+2];
		String inputLine;
		int decodedInt;

		for (int r=1; r<rowTotal+1; r++){
			inputLine = sc.nextLine();
			for (int c=1; c<colTotal+1; c++){
				// char x = inputLine.charAt(c);
				// int x2 = x - '0';
				grid[r][c] = inputLine.charAt(c-1);
				// grid[r][c] = decodedInt;
				
				// System.out.println(x2);
				// visited[r][c]=0;
				// parent[r][c]=-1;


			}
			// nextLine = sc.nextLine();
		}

		// start path finding
		GraphTree myGraph = new GraphTree(grid);
		int row, col;
		ArrayList<Vertex> verticesToProcess = new ArrayList<>();
		ArrayList<Vertex> verticesChecker = new ArrayList<>();
		for (int r=1; r<rowTotal+1; r++){
			for (int c=1; c<colTotal+1; c++){
				Vertex v1,v2;
				boolean cond1= (grid[r][c]==grid[r+1][c]);
				boolean cond2= (grid[r][c]==grid[r][c+1]);
				// boolean cond3= grid[r][c]=='L';

				if (cond1) {
					v1=myGraph.vertices[r][c];
					v2=myGraph.vertices[r+1][c];
					myGraph.addEdge(v1,v2);
					// verticesToProcess.add(v1);
				}
				if (cond2) {
					v1=myGraph.vertices[r][c];
					v2=myGraph.vertices[r][c+1];
					myGraph.addEdge(v1, v2);
					// verticesToProcess.add(v1);
		
				}

				// if(cond3) {
				// 	verticesToProcess.add(myGraph.vertices[r][c]);
				// }

			}
		}


		int queryTotal = sc.nextInt();
		sc.nextLine();
		int startr, startc, endr, endc;
		int[] reachable = new int[queryTotal];
		Arrays.fill(reachable,0);
		for (int queryNo=0; queryNo<queryTotal;queryNo++){
			startr = sc.nextInt();
			startc = sc.nextInt();
			endr = sc.nextInt();
			endc = sc.nextInt();
			sc.nextLine();

			visited=new int[rowTotal+2][colTotal+2];
			p=new int[rowTotal+2][colTotal+2][2];
			// Arrays.fill(visited,0);
			// Arrays.fill(visited,-1);

			for (int r=0; r<visited.length; r++){
				for (int c=0; c< visited[0].length; c++){
					visited[r][c]=0;
					p[r][c]=new int[] {-1,-1};
				}
			}


			PriorityQueue<Vertex> pq = new PriorityQueue<>(rowTotal*colTotal,new CompareVertex());

			pq.add(myGraph.vertices[startr][startc]);
			visited[startr][startc]=1;

			boolean isBinary= (grid[startr][startc]=='0');
			// System.out.printf("myGraph.vertices[startr][startc] %c startr %d startc %d", grid[startr][startc], startr, startc);
			// System.out.println("binary?"+isBinary);
			Vertex vTmp;
			while(pq.size()>0){
				vTmp = pq.poll();
				for (Vertex vNeighbour:vTmp.neighbours){
					int neighR = vNeighbour.row;
					int neighC = vNeighbour.col;

					if (neighR==endr & neighC==endc){
						if (isBinary) {
							reachable[queryNo] = 2;

						} else {
							reachable[queryNo] = 1;

						}
						break;
					}

					if (visited[neighR][neighC]==0){
						visited[neighR][neighC]=1;
						p[neighR][neighC]=new int[] {vTmp.row,vTmp.col};
						pq.add(myGraph.vertices[neighR][neighC]);
					} 
				}
			}

		}
		// pq.add(new Vertex(1,1,'1'));
		// pq.add(new Vertex(1,2,'1'));
		// pq.add(new Vertex(1,0,'1'));
		// System.out.println(pq.poll().col);

		// System.out.println(pq.poll().col);
		// System.out.println(pq.poll().col);
		// System.out.println(Arrays.toString(reachable));


		// System.out.println(Arrays.deepToString(grid));

		for (int x:reachable){
			if (x==2){
				System.out.println("binary");
			} else if (x==1) {
				System.out.println("decimal");				
			} else {
				System.out.println("neither");
			}
		}
	}
}

class Vertex{
	ArrayList<Vertex> neighbours = new ArrayList<>();
	int col, row;
	char key;
	int visited = 0; // 0=unvisited, 1=explored, 2=visited

	Vertex(int row, int col, char key){
		this.row = row;
		this.col = col;
		this.key = key;
		
	}
}


class GraphTree{
	char [][] grid;
	Vertex[][] vertices;
	int[][] p;
	int[][] visited;

	GraphTree (char[][] grid){
		this.grid=grid;
		this.vertices = new Vertex[grid.length][grid[0].length];
		for (int r=0; r<grid.length;r++){
			for(int c=0; c<grid[0].length;c++){
				this.vertices[r][c]=new Vertex(r,c,grid[r][c]);
			}
		}

	}

	public void addEdge(Vertex v1, Vertex v2){
		v1.neighbours.add(v2);
		v2.neighbours.add(v1);
		HashMap<String,Integer> myHash = new HashMap<>();
		vertices[v1.row][v1.col] = v1;
		vertices[v2.row][v2.col] = v2;
	}

	int count=0;
	boolean hasL=false;

	public void DFS(Vertex v){
		if (v.key=='L'){
			this.hasL=true;
		}

		for (Vertex nb: v.neighbours){
			if (nb.visited == 0){
				v.visited=1;
				DFS(nb);
			}

		}

		v.visited = 2;
	}	

	public void reset(){
		Arrays.fill(p,-1);
		Arrays.fill(visited,0);
	}

	public void BFS(int r, int c){
		PriorityQueue pq = new PriorityQueue();


	}
}

class CompareVertex implements Comparator<Vertex>{
	public int compare(Vertex v1, Vertex v2){
		if (v1.row!=v2.row){
			return v1.row-v2.row;
		} else {
			return v1.col-v2.col;
		}
	}
}