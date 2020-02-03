import java.io.*;  
import java.util.*;
public class LostMap{    
 public static void main(String args[]){
     

  try{    
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));    
    OutputStream out = new BufferedOutputStream(System.out);
    int villageTotal=Integer.parseInt(br.readLine());
    out.flush();
    
    int[][] grid = new int[villageTotal][villageTotal];
    PriorityQueue<Edge> edgeList = new PriorityQueue<>(villageTotal*villageTotal, new EdgeCompare());
    
    String input;
    String[] inputSplits;
    int weight;
    for (int i=0; i<villageTotal;i++){
      input=br.readLine();
      inputSplits=input.split(" ");
      
      for (int j=0; j<villageTotal;j++){
          weight=Integer.parseInt(inputSplits[j]);
          grid[i][j]=weight;
          if (i!=j){
              boolean success=edgeList.add(new Edge(i,j,weight));
              
          }
      }
      
    }    

    UnionFind disjointSet = new UnionFind(villageTotal);
    ArrayList<Edge> result = new ArrayList<>();
    int[] visited = new int[villageTotal];

    while(true){
      Edge edgeX=edgeList.peek();
      if (edgeX==null){
        break;
      }

      boolean cond = ( !disjointSet.isSameSet(edgeX.i,edgeX.j));
      if(cond){
        result.add(edgeX);
        visited[edgeX.i]=1;
        visited[edgeX.j]=1;
        disjointSet.unionSet(edgeX.i,edgeX.j);
        
      }
      edgeList.remove(edgeX);
    }


    Collections.sort(result, new sortByID());
    for(Edge e:result){
      if(e.i<e.j){
        System.out.println((e.i+1)+" "+ (e.j+1));
      } else {
        System.out.println((e.j+1)+" "+ (e.i+1));
      }
    }
    
    
    br.close();    
    out.close();    
  }catch(Exception e){System.out.println(e);}    
 }    
}  

class Edge{
    boolean visited=false;
    int i,j,weight;
    Edge(int i, int j, int weight){
        this.i=i;
        this.j=j;
        this.weight=weight;
    }
    
    public void printString(){
        System.out.println("edge (i,j,weight):"+i+" "+j+" "+weight);
    }
    
}

class EdgeCompare implements Comparator<Edge> {
    public int compare(Edge e1, Edge e2){
        if (e1.weight!=e2.weight){
            return e1.weight-e2.weight;
        } else {
            if (e1.i!=e2.i){
                return e1.i - e2.i;
            } else{
                return e1.j-e2.j;
            }
        }
    }
}

class sortByID implements Comparator<Edge> {
  public int compare(Edge e1, Edge e2){
    return e1.i - e2.i;
  }
}

class UnionFind {                                              
  public int[] p;
  public int[] rank;
  public int numSets;

  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    numSets = N;
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
    }
  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      numSets--; 
      int x = findSet(i), y = findSet(j);
      if (rank[x] > rank[y]) 
      	p[y] = x;
      else { 
      	p[x] = y;
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }

  public int numDisjointSets() { return numSets; }
}
