import java.util.*;

public class Ladice{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int itemTotal = sc.nextInt();
		int drawerTotal = sc.nextInt();
		String extraLine=sc.nextLine();
		Ufds ufds1 = new Ufds(drawerTotal);
		int unionSuccess, updateSuccess;

		for (int itemNo=0; itemNo<itemTotal; itemNo++){
			int itemA = sc.nextInt() - 1;
			int itemB = sc.nextInt() - 1;
			ufds1.union(itemA, itemB);
			updateSuccess=ufds1.updateOccupancy(itemA);

			// System.out.println("ranks: "+Arrays.toString(ufds1.ranks));
			// System.out.println("parent: "+Arrays.toString(ufds1.parent));
			// System.out.println("len: "+Arrays.toString(ufds1.len));
			// System.out.println("occupied: "+Arrays.toString(ufds1.occupied));
			if(updateSuccess==1){
				System.out.println("LADICA");
			} else {
				System.out.println("SMECE");
			}

			extraLine = sc.nextLine();
		}

	}




}

class Ufds{
	int[] len, parent, ranks, occupied;

	Ufds(int n){
		this.len = new int[n];
		this.ranks = new int[n];
		this.occupied = new int[n];
		this.parent = new int[n];
		Arrays.fill(this.len, 1);
		Arrays.fill(this.ranks, 0);
		Arrays.fill(this.occupied, 0);
		for (int i=0; i<n; i++){
			this.parent[i]=i;
		}
	}

	int getRoot(int node){
		if (node == parent[node]){
			return node;
		} else {
			return getRoot(parent[node]);
		}
	}

	int union(int node1, int node2){
		int root1 = getRoot(node1);
		int root2 = getRoot(node2);
		if (root1 == root2){
			return 0;
		} 
		if (ranks[root1]>ranks[root2]){
			parent[root2]=root1;
			len[root1]+=len[root2];
			occupied[root1]+=occupied[root2];
			
		} else {
			parent[root1]=root2;
			len[root2]+=len[root1];
			occupied[root2]+=occupied[root1];
			if (ranks[root1] == ranks[root2]){
				ranks[root2]++;
			}
		}

		return 1;

	}
	int updateOccupancy(int node){
		int root = getRoot(node);
		occupied[root]++;
		if (len[root]<occupied[root]){
			occupied[root]--;
			return 0;
		}
		return 1;
	}
 
}