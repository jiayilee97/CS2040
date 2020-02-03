import java.util.*;

public class Lab7{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int vertexTotal = sc.nextInt();
		String nextLineCatcher = sc.nextLine();

		while (vertexTotal != -1){
			ArrayList<ArrayList<Integer>> adjMat= new ArrayList<>();

			// read the input
			for (int v=0; v<vertexTotal; v++){

				ArrayList<Integer> row = new ArrayList<>();

				for (int v2=0; v2<vertexTotal; v2++){
					row.add(sc.nextInt());
				}

				adjMat.add(row);
			}

			// check for weak vertex
			ArrayList<Integer> weakVertices = new ArrayList<>();
			for (int v=0; v<vertexTotal; v++){
				int edgeTotal=0;
				int edge;
				ArrayList<Integer> activeVertices = new ArrayList<>();
				
				// identify neighbouring (active) vertices 
				for(int v2=0; v2< vertexTotal; v2++){
					edge = adjMat.get(v).get(v2);
					if (edge == 1){
						edgeTotal += 1;

						activeVertices.add(v2);
					}

				}

				// compare the active vertices
				if (edgeTotal<2) {
					weakVertices.add(v);					
				} else {
					if (containsWeak(adjMat, activeVertices) == false){
						weakVertices.add(v);
					}

				}
			}

			// print the weak vertices
			for (int v=0; v<weakVertices.size(); v++){
				System.out.print(weakVertices.get(v));

				// print space (except for last weak vertex)
				if (v!= weakVertices.size()-1){
					System.out.print(" ");
				}
			}
			System.out.println();
			
			vertexTotal = sc.nextInt();
			nextLineCatcher = sc.nextLine();
		}

	}

	// check if any two of a list of active vertices are connected to each other
	public static boolean containsWeak(ArrayList<ArrayList<Integer>> adjMat, ArrayList<Integer> activeVertices){
		for (Integer v: activeVertices){
			for(Integer v2: activeVertices){
				if (! v.equals(v2) ){
					if (adjMat.get(v).get(v2) == 1){
						return true;
					}
				}
			}
		}
		return false;
	}

}