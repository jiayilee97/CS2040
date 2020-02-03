import java.util.*;

public class Cannonball{

	public static final double INF = 1000000000.0;
	public static double[] D;
	public static int[]p;

	public static void relax(int u, int v, double w_u_v) {
	    if (D[u] != INF && D[v] > D[u] + w_u_v) { // if SP can be shortened
	      D[v]= D[u] + w_u_v; // relax this edge
	      p[v]= u; // remember/update the predecessor
    	}
	  }

	public static void backtrack(int s, int u) {
	    if (u == -1 || u == s) {
	      return;
	    }
	    backtrack(s, p[u]);
    }

	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		HashMap<String,Double> myHash = new HashMap<>();
		myHash.put("startx",sc.nextDouble());
		myHash.put("starty",sc.nextDouble());
		sc.nextLine();
		myHash.put("endx",sc.nextDouble());
		myHash.put("endy",sc.nextDouble());
		
		int cannonTotal = sc.nextInt();
		sc.nextLine();


		Double[][] coords = new Double[cannonTotal+2][2];

		coords[0] = new Double[] {myHash.get("startx"),myHash.get("starty")};
		coords[1] = new Double[] {myHash.get("endx"),myHash.get("endy")};

		// read input
		for (int cannonNo=0; cannonNo<cannonTotal; cannonNo++){

			coords[cannonNo+2]=new Double[] {sc.nextDouble(), sc.nextDouble()};

			sc.nextLine();

		}

		// initialise SSSP
		Double[][] graph = new Double[cannonTotal+2][cannonTotal+2];

		for(int r=0; r<coords.length;r++){
			for(int c=0; c<coords.length;c++){
				graph[r][c]=INF;
			}
		}

		double hypo;
		double extraDist;

		// build adjacency matrix 
		for(int r=0; r < 1; r++){
			for(int c=0; c < coords.length; c++){
				if (r!=c){
					hypo=Math.hypot(coords[r][0]-coords[c][0],coords[r][1]-coords[c][1]);
					graph[r][c]=hypo/5;
					graph[c][r]=graph[r][c];

				}
			}
		}
		// build adjacency matrix (continued)
		for (int r=1; r < coords.length; r++){
			for (int c=1; c<coords.length; c++){
				if (r!=c) {
					hypo=Math.hypot(coords[r][0]-coords[c][0],coords[r][1]-coords[c][1]);
					
					extraDist=Math.abs(hypo-50);
					
					graph[r][c]=2+extraDist/5;
				}
			}
		}




		D=new double[cannonTotal+2];
		p=new int[cannonTotal+2];
		Arrays.fill(D,INF);
		Arrays.fill(p,-1);
		D[0]=0;

		int V=coords.length;

		// relax
		for(int i=0; i < V-1; i++){
			for(int u=0; u < V; u++ ){
				for(int j=0; j<V; j++){
					relax(u,j,graph[u][j]);
				}
			}
		}
		

      	System.out.println(D[1]);

	}
}