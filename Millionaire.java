import java.util.*;
import java.io.*;  

public class Millionaire{

	public static final int INF=-10000;

	public static void main(String [] args){
		try{

		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));    
		    OutputStream out = new BufferedOutputStream(System.out);
	    
			String[] str=br.readLine().split(" ");

		    int rowTotal=Integer.parseInt(str[0]);
		    int colTotal=Integer.parseInt(str[1]);

			int[][] grid = new int[rowTotal+2][colTotal+2];
			String inputLine;
			int decodedInt;

			
			for(int r=0; r<grid.length; r++){
				for(int c=0; c<grid[0].length;c++){
					grid[r][c]=INF;
				}
			}

		    String input;
		    String[]inputSplits;

			for (int r=1; r<rowTotal+1; r++){
			    input=br.readLine();
			    inputSplits=input.split(" ");
				
				for (int c=1; c<colTotal+1; c++){
					grid[r][c] = Integer.parseInt(inputSplits[c-1]);

				}
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

					v1=myGraph.vertices[r][c];
					v2=myGraph.vertices[r+1][c];
					myGraph.addEdge(v1,v2, v2.key - v1.key);

					v1=myGraph.vertices[r][c];
					v2=myGraph.vertices[r][c+1];
					myGraph.addEdge(v1, v2, v2.key - v1.key);

				}
			}

			// initialise
			int[][] visited = new int[rowTotal+2][colTotal+2];
			int[][][] p = new int[rowTotal+2][colTotal+2][2];
			for (int r=0; r<visited.length; r++){
				
				for (int c=0; c< visited[0].length; c++){
					visited[r][c]=0;
					p[r][c]=new int[] {-1,-1};
				}


			}

			PriorityQueue<NeighbourWeight> pq = new PriorityQueue<>(rowTotal*colTotal,new CompareNW());
			int startr=1;
			int startc=1;
			Vertex startVertex=myGraph.vertices[startr][startc];
			visited[startr][startc]=1;
			p[startr][startc]=new int[] {startr,startc};

			for (NeighbourWeight nw:startVertex.neighbours){
				pq.add(nw);
			}

			NeighbourWeight tmpNW;
			int uRow,uCol, vRow, vCol;

			// Prim's Algorithm
			while(pq.size()>0){
				tmpNW = pq.poll();
				uRow = tmpNW.vertexSource.row;
				uCol = tmpNW.vertexSource.col;
				vRow = tmpNW.vertexDest.row;
				vCol = tmpNW.vertexDest.col;

				if (visited[vRow][vCol] == 0) {
					p[vRow][vCol] = new int[] {uRow,uCol};
					visited[vRow][vCol]=1;
				}

				for(NeighbourWeight nw: tmpNW.vertexDest.neighbours){
					vRow = nw.vertexDest.row;
					vCol = nw.vertexDest.col;
					
					if (visited[vRow][vCol]==0){
						pq.add(nw);
					}


				}

			}


			// backtrack
			vRow=rowTotal;
			vCol=colTotal;
			int vRowNext,vColNext;
			int maxLadder=0;
			while(!(p[vRow][vCol][0]==vRow & p[vRow][vCol][1]==vCol)){

				
				if(p[vRow][vCol][0]==vRow & p[vRow][vCol][1]==vCol){
					break;
				}

				vRowNext=p[vRow][vCol][0];
				vColNext=p[vRow][vCol][1];
				int diff = -(grid[vRowNext][vColNext]-grid[vRow][vCol]);
				if (diff>maxLadder){
					maxLadder=diff;
				}
				vRow=vRowNext;
				vCol=vColNext;

			}

			System.out.println(maxLadder);
			br.close();
			out.close();
		} catch(Exception e){System.out.println(e);}   

	}


}

class NeighbourWeight{
	Vertex vertexSource;
	Vertex vertexDest;
	int weight;

	NeighbourWeight(Vertex vertexSource,Vertex vertexDest, int weight){
		this.vertexSource=vertexSource;
		this.vertexDest=vertexDest;
		this.weight=weight;
	}

	void printString(){
		System.out.println(" weight: "+this.weight);
	}
}

class Vertex{
	ArrayList<NeighbourWeight> neighbours = new ArrayList<>();
	int col, row;
	int key;
	int visited = 0; // 0=unvisited, 1=explored, 2=visited

	Vertex(int row, int col, int key){
		this.row = row;
		this.col = col;
		this.key = key;
		
	}
}


class GraphTree{
	int [][] grid;
	Vertex[][] vertices;
	int[][] p;
	int[][] visited;

	GraphTree (int[][] grid){
		this.grid=grid;
		this.vertices = new Vertex[grid.length][grid[0].length];
		for (int r=0; r<grid.length;r++){
			for(int c=0; c<grid[0].length;c++){
				this.vertices[r][c]=new Vertex(r,c,grid[r][c]);
			}
		}

	}

	public void addEdge(Vertex v1, Vertex v2, int weight){
			NeighbourWeight nw1=new NeighbourWeight(v1,v2,weight);
			v1.neighbours.add(nw1);

			NeighbourWeight nw2=new NeighbourWeight(v2,v1,-weight);
			v2.neighbours.add(nw2);

		HashMap<String,Integer> myHash = new HashMap<>();
		vertices[v1.row][v1.col] = v1;
		vertices[v2.row][v2.col] = v2;
	}

}

class CompareNW implements Comparator<NeighbourWeight>{
	public int compare(NeighbourWeight nw1, NeighbourWeight nw2){

		if (nw1.weight!=nw2.weight){
			return nw1.weight-nw2.weight;
		} else {
			if (nw1.vertexDest.row!=nw2.vertexDest.row){
				return nw1.vertexDest.row-nw2.vertexDest.row;
			} else {
				return nw1.vertexDest.col-nw2.vertexDest.col;
			}
		}
	}
}