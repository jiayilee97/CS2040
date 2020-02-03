import java.util.*;

public class Islands{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		Stack myStack = new Stack();
		int rowTotal=sc.nextInt();
		int colTotal=sc.nextInt();
		String nextLnCatcher=sc.nextLine();
		char[][] grid= new char [rowTotal+2][colTotal+2];
		String line;


		for (int r=1; r<rowTotal+1; r++ ){
			line = sc.next();

			for (int c=1; c<colTotal+1; c++){
				grid[r][c] = line.charAt(c-1);
			}
			nextLnCatcher=sc.nextLine();

		}

		// start path finding
		GraphTree myGraph = new GraphTree(grid);

		int row, col;
		ArrayList<Vertex> verticesToProcess = new ArrayList<>();
		ArrayList<Vertex> verticesChecker = new ArrayList<>();
		for (int r=1; r<rowTotal+1; r++){
			for (int c=1; c<colTotal+1; c++){
				Vertex v1,v2;
				boolean cond1= ((grid[r][c]=='L' | grid[r][c]=='C')  & (grid[r+1][c]=='L' | grid[r+1][c]=='C'));
				boolean cond2= ((grid[r][c]=='L' | grid[r][c]=='C')  & (grid[r][c+1]=='L' | grid[r][c+1]=='C'));
				boolean cond3= grid[r][c]=='L';
				if (cond1) {
					v1=myGraph.vertices[r][c];
					v2=myGraph.vertices[r+1][c];
					myGraph.addEdge(v1,v2);
					verticesToProcess.add(v1);
				}
				if (cond2) {
					v1=myGraph.vertices[r][c];
					v2=myGraph.vertices[r][c+1];
					
					myGraph.addEdge(v1, v2);
					verticesToProcess.add(v1);
		
				}

				if(cond3) {
					verticesToProcess.add(myGraph.vertices[r][c]);
				}

			}
		}

		int islandsMin=0;

		for(Vertex v:verticesToProcess){
			if(v.neighbours.size()!=0){

				myGraph.hasL=false;

				if (v!=null & v.visited==0){
					myGraph.DFS(v);
					if (myGraph.hasL==true){
						islandsMin++;
					}
				} 
			} else {
				islandsMin++;
			}
		}

	System.out.println(islandsMin);
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
}
