import java.util.*;

public class GCPC{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int teamTotal = sc.nextInt();
		int eventTotal = sc.nextInt();
		String nextline = sc.nextLine();
// 		AVL myAVL = new AVL(teamTotal);

        // test cases
        // int[] arr = {3,5,1,2,4,0,7,6,8,9};
        AVL myAVL = new AVL(100000);

        // myAVL.insert(new Vertex(3, 3, 1));
        // myAVL.insert(new Vertex(5, 3, 1));
        // myAVL.insert(new Vertex(4, 3, 1));
        // myAVL.insert(new Vertex(1, 1, 1));
        // myAVL.insert(new Vertex(2, 2, 1));
        // myAVL.insert(new Vertex(6, 3, 2));
        // myAVL.insert(new Vertex(7, 2, 1));
        // myAVL.insert(new Vertex(8, 0, 1));
        // myAVL.remove(3);
        // myAVL.remove(2);
        // myAVL.remove(4);
        // myAVL.remove(7);

        // myAVL.insert(new Vertex(4, 4, 1));
        // myAVL.insert(new Vertex(0, 0, 1));
        // myAVL.insert(new Vertex(7, 7, 1));
        // myAVL.insert(new Vertex(6, 6, 1));
        // myAVL.insert(new Vertex(8, 8, 1));
        // myAVL.insert(new Vertex(9, 9, 1));
        // int[] arr = {3,4,5,6,7,8,9,0,1,2};

        // int[] arr = {2,4,1,0,3};
        // for (int i=0; i < arr.length; i++){
        //     myAVL.insert(new Vertex(arr[i],arr[i],1));
        // }
        // int[] arr2 = {4,2,1,0,3};
        // for (int i=0; i<arr2.length; i++){
        // 	myAVL.remove(arr2[i]);
        // }
        
        
        // for (int i=0; i < arr.length; i++){
        //     myAVL.insert(new Vertex(arr[i],arr[i],1));
        // }

        // myAVL.remove(5);		
        // myAVL.remove(1);		
        // myAVL.remove(6);		
        // myAVL.remove(8);		
        // myAVL.remove(7);		
        // myAVL.remove(0);		
        // myAVL.remove(9);		
        // myAVL.remove(3);		
        // myAVL.remove(4);		
        // myAVL.remove(2);	
        // myAVL.insert(new Vertex(1,1,1));
        // myAVL.insert(new Vertex(2,2,1));
        // myAVL.insert(new Vertex(3,3,1));
        
	    // System.out.println("max"+Math.max(arr));
        // myAVL.getByTeamNo(1).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(2).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(3).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(4).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(5).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(6).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(7).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(8).printAll();
        // System.out.println();
        // myAVL.getByTeamNo(9).printAll();
        
        // for (int i=0; i<10; i++){
	       //  System.out.println("Successor:"+myAVL.getSuccessor(myAVL.getByTeamNo(i)).teamNo);

        // }
		// System.out.println("checking node 3xx:"+myAVL.getByTeamNo(3).size);
  //       System.out.println("rank:"+myAVL.getRank(myAVL.rootVertex,myAVL.getByTeamNo(2)));
		int teamID;
		int teamPen;
		myAVL.insert(new Vertex(0,0,0));
		for(int event = 0; event< eventTotal; event++){
			
			// System.out.println("---------------------root(Before):"+myAVL.rootVertex.teamNo);
			teamID = sc.nextInt()-1;
			teamPen = sc.nextInt();
			if (event !=0){
				// System.out.println("---------------------root1:"+myAVL.rootVertex.teamNo);
				Vertex removedV = myAVL.remove(teamID);
				// System.out.println("---------------------root2:"+myAVL.rootVertex.teamNo);	
				myAVL.insert(new Vertex(teamID,removedV.wins+1, removedV.penalty+teamPen));
	
			} else {
				// System.out.println("---------------------root3:"+myAVL.rootVertex.teamNo);	
				myAVL.insert(new Vertex(teamID,1, teamPen));			
			}
			nextline = sc.nextLine();
			// System.out.println("---------------------root(After):"+myAVL.rootVertex.teamNo);
			if (myAVL.rootVertex!=null){
		        // System.out.println("root:"+myAVL.rootVertex.teamNo);
	        } else {
	        	// System.out.println("root: "+ myAVL.rootVertex);
	        }
	     //    for (int i=0; i < 10; i++){
		    //     myAVL.getByTeamNo(i).printAll();
		    //     System.out.println();
		    // }
			System.out.println(myAVL.getRank(myAVL.rootVertex,myAVL.getByTeamNo(0)));

		}
		// System.out.println("team 1:"+myAVL.getRank(myAVL.rootVertex,myAVL.getByTeamNo(0)));
		// System.out.println("\n");
     //    System.out.println("checking:");
     //    if (myAVL.rootVertex!=null){
	    //     System.out.println("root:"+myAVL.rootVertex.teamNo);
     //    } else {
     //    	System.out.println("root: "+ myAVL.rootVertex);
     //    }
     //    for (int i=0; i < 10; i++){
	    //     myAVL.getByTeamNo(i).printAll();
	    //     System.out.println();
	    // }
	}
}

class Vertex{
	int value;
	Vertex left;
	Vertex right;
	Vertex parent;
	// int key;
	int wins;
	int penalty;
	boolean active;
	public int teamNo;
	int size;
	int height;
	Vertex successor;
	public int countH=0;
	int duplicateCount=0;
	int duplicateLeader=-1;
	LinkedList<Vertex> duplicateVertices = new LinkedList<>();
	

	Vertex(int teamNo, int wins, int penalty){
		this.wins = wins;
		this.penalty = penalty;
		this.active = false;
		this.teamNo = teamNo;
		this.left = null;
		this.right = null;
		this.parent = null;
		// this.key = key;
		this.height = 0;
	}
	
	int compareTo(Vertex v){
		// -1 means this vertex loses to v
		// 0 means this vertex ties with v
		// 1 means this vertex wins over v
		// System.out.println("vH123"+this.wins+v.wins);
		// System.out.println("ahem"+this.penalty+v.penalty);
		if (this.wins>v.wins){
			// System.out.println("return 1");
			return 1;
		} else if (this.wins == v.wins){
			// System.out.println("return -1");
			if (this.penalty<v.penalty){
				return 1;
			} else if (this.penalty==v.penalty) {
				return 0;
			} else {
				return -1;
			}
		} else {
			// System.out.println("return -1");
			return -1;
		}
	}

	int getHeight(){
		// countH++;
		// System.out.println("countH:"+countH);
		// if (countH>50) throw new IllegalAccessError();

		if (this==null){
			// System.out.println("this is null");
			return -1;
		} else{
			if (left==null & right ==null){
		    	// System.out.println("both null");
	    	    return 0;
		    } else if (left != null & right==null){
		    	// System.out.println("gh2");
		        return left.getHeight() + 1;
		        
		    } else if (left == null & right != null){
		    	// System.out.println("gh3");
		        return right.getHeight() + 1;  
	        } else {
	        	// System.out.println("hhh");
	        	// return 0;

	        	// System.out.println("gh4");
	        	// System.out.println("left:"+left.teamNo+left.left+left.right);
	        	// System.out.println("right:"+right.teamNo+right.left+right.right);

	        	int leftH = left.getHeight();
	        	// System.out.println("passedLeft");
	        	int rightH = right.getHeight();
	        	// System.out.println("passedRight");
	        	// System.out.println("leftH:"+leftH);
	        	// System.out.println("rightH:"+rightH);
		        return Math.max(leftH,rightH ) + 1;
		    }
		} 
		
	}
	
	int getSize(){
	    if(left==null & right ==null){
    	    return 1 + this.duplicateVertices.size();
	    } else if (left != null & right==null){
	        return left.getSize() + 1 +this.duplicateVertices.size();
	        
	    } else if (left == null & right != null){
	        return right.getSize() + 1 + this.duplicateVertices.size();  
        } else {
	        return left.getSize() + right.getSize() + 1 + this.duplicateVertices.size();
	    }
	}
	
	void update(int penalty){
		this.wins +=1;
		this.penalty += penalty;
	}
	
	void printAll(){
	   //  System.out.println("teamNo:"+teamNo);
	   //  System.out.println("value:"+value);
	   // // System.out.println("left:"+left);
	   // // System.out.println("right:"+right);
	   //  System.out.println("wins:"+wins);
	   //  System.out.println("penalty:"+penalty);
	   //  System.out.println("active:"+active);
	   //  // System.out.println("parent:"+parent);
	   //  if (parent != null){
	   //      System.out.println("parent teamNo:"+parent.teamNo);
	   //  }
	   //  if (left != null){
	   //      System.out.println("left teamNo:"+left.teamNo);
	   //  }
	   //  if (right != null){
	   //      System.out.println("right teamNo:"+right.teamNo);
	   //  }
	   //  System.out.println("height:"+getHeight());
	   //  System.out.println("size:"+getSize());
	   //  System.out.println("duplicateCount:"+duplicateCount);
	   //  System.out.println("duplicateLeader:"+duplicateLeader);
	   //  if(duplicateVertices!=null){
	   //  	for(Vertex dupV:duplicateVertices){
			 //    System.out.println("duplicateVertices:"+dupV.teamNo);
	   //  	}
	   //  }
	}
}

class AVL{
	int size=0;
	Vertex rootVertex;
	ArrayList<Vertex> vertices = new ArrayList<>();

	AVL(int N){
		
		for (int i=0; i<N; i++){
			vertices.add(new Vertex(i,0, 0));
		}
	}

    Vertex getByTeamNo(int teamNo){
        return vertices.get(teamNo);
    }

	Vertex getSuccessor(Vertex v){
		// System.out.println("currentNode:"+v.teamNo);
		
		// Vertex v = this;
		// boolean finish = false;

		if (v.right!=null){
			v=v.right;
			while (v!=null){
				// System.out.println("currentNode:"+v.teamNo);
				if (v.left!=null){
					v=v.left;
				} else {
					return v;
				}
			}
			return v.right;
		} else {
			
			// Vertex parentVertex = v.parent;
	
			while (v!=null){
				// System.out.println("currentNode:"+v.teamNo);
				if (v.parent!=null){
					if (v.parent.left == v){
						return v.parent;
					} else {
						v=v.parent;
					}
				} else {
					return null;
				}
			}
			return null;
		}


		// Vertex parentVertex=this.parent;
		// if (parentVertex != null){
		// 	if (this.parent.left == this){
		// 		return this.parent;
		// 	} else {
		// 		return parentVertex.getSuccessor();
		// 	}
		// } else {
		// 	return null;
		// }
	}
    
	int getRank(Vertex refVertex, Vertex targetVertex){
		

		// System.out.println("checking node 3:"+getByTeamNo(3).size);
		// System.out.println("ranking..."+refVertex.teamNo+targetVertex.teamNo);
		// System.out.println("targetVertex:"+targetVertex+refVertex);
		// System.out.println("comparing teams:"+targetVertex.teamNo+refVertex.teamNo);
		int output = targetVertex.compareTo(refVertex);
		// System.out.println("checking node 3:"+getByTeamNo(3).size);

		if (output==1){  // targetVertex wins refVertex, hence targetVertex is left of refVertex
			// System.out.println("case1");
			return getRank(refVertex.left, targetVertex);
		} else if (output==0) {
			// System.out.println("case2");
			// System.out.println("ref:"+refVertex);
			if (targetVertex.parent==null){
				if (refVertex.left!=null){
					// System.out.println("over here:"+refVertex.left.size);
					return 1+refVertex.left.getSize() ;
				} else {
					return 1;
				}
			}

			if (targetVertex.left!=null){

				// System.out.println("case2a");
				int tvSubtreeSize = targetVertex.left.getSize();
				// System.out.println("tvSubtreeSize:"+tvSubtreeSize);
				int duplicateSize = targetVertex.duplicateVertices.size();
				// System.out.println("duplicateSize"+duplicateSize);
				return tvSubtreeSize + 1;	
			} else {
				// System.out.println("case2b");
				// System.out.println("refVertex"+refVertex.parent.teamNo);
				return 1;
			}
		} 
		// System.out.println("case3");
		// System.out.println("refVertex.left:"+getRank(refVertex.right,targetVertex) );
		// System.out.println("done");
		if (refVertex.left!=null & refVertex.right!=null){
			// System.out.println("case3a");
			return getRank(refVertex.right,targetVertex) + refVertex.left.getSize()+1+refVertex.duplicateVertices.size();
		} else  if (refVertex.right!=null) {
			// System.out.println("case3b");
			return getRank(refVertex.right,targetVertex) + 1+refVertex.duplicateVertices.size();
		} else {
			// System.out.println("case3c");
			return 0;
		}
	}

    Vertex rotateRight(Vertex w){
        Vertex T = w.left;
        T.parent = w.parent;
        w.parent = T;
        w.left = T.right;
        if (w.left != null) w.left.parent = w;
        T.right = w;
        
        if (T.parent != null){
	        if (T.parent.right==w) {
	            T.parent.right = T;
	        } else if (T.parent.left==w){
	            T.parent.left = T;
	        } 
        } else {
        	rootVertex = T;
        }
        
        // update root vertex
        // if (w.parent==null){
        //     rootVertex=w;
        // } else if (T.parent==null){
        //     rootVertex=T;
        // }
        
        w.height = w.getHeight();
        T.height = T.getHeight();
        
        return T;
    }
    
    Vertex rotateLeft(Vertex T){
        Vertex w = T.right;
        w.parent = T.parent;
        T.parent = w;
        T.right = w.left;
        if (w.left != null) w.left.parent = T;
        w.left = T;

        if (w.parent != null){
            if (w.parent.right==T) {
                w.parent.right = w;
            } else if (w.parent.left==T){
                w.parent.left = w;
            }
            
        } else {
        	rootVertex = w;
        }
		// System.out.println("parent is:"+w.parent);    
		// System.out.println("rootVertex is:"+rootVertex.teamNo); 

        // update root vertex
        // if (w.parent==null){
        //     rootVertex=w;
        // } else if (T.parent==null){
        //     rootVertex=T;
        // }
        
        T.height = T.getHeight();
        w.height = w.getHeight();
        
        return w;
    }
	
	void insert(Vertex v){
	    size++;
		int teamNo;
		teamNo = v.teamNo;
	    // System.out.println("rootVertex:"+rootVertex);
	    // System.out.println("inserting " + teamNo + " wins:" + v.wins+" penalty:"+v.penalty);
// 		if (v.wins < rootVertex.wins){
		Vertex child = rootVertex;

		Vertex vFinal=null;
	    
		// System.out.println("x3" + child);
		// v.printAll();
		if (child == null){
		    rootVertex = v;
    		// System.out.println("rootVXC" + rootVertex);
		    // System.out.println("\n");
		    
		} else {
    		boolean lastTraverseIsLeft = false;

    		while(child != null){
    		    
    		    vFinal = child;
    		    
                // System.out.println("child team:"+child.teamNo);
                
    			if (v.wins > child.wins){
    				child = child.left;
    				// System.out.println("left");
    				lastTraverseIsLeft = true;
    			} else if (v.wins == child.wins) {
    			    // System.out.println("equals");
    			    if (v.penalty > child.penalty) {
    			        child = child.right;
    			        lastTraverseIsLeft = false;
    			    } else if (v.penalty < child.penalty) {
    			        child = child.left;
    			        lastTraverseIsLeft = true;
    			    } else if (v.penalty == child.penalty){
    			    	// child.duplicateCount++;
    			    	child.duplicateLeader=child.teamNo;
    			    	v.duplicateLeader=child.teamNo;
    			    	child.duplicateVertices.add(v);
    			    	// System.out.println("duplicate found:"+child.teamNo+child.duplicateCount);
    			    	// System.out.println("team no:"+v.teamNo+child.teamNo);
    			    	// System.out.println("duplicate leader:"+v.duplicateLeader+child.duplicateLeader);
    			    	vertices.set(teamNo, v);
    			    	this.rebalance(v);
    			    	// System.out.println("ROOTVERTEX"+rootVertex.teamNo);
    			    	return;
    			    }
    			} else {
    				child = child.right;
    				// System.out.println("right");
    				lastTraverseIsLeft = false;
    			}
    		}
    		
    		
    	    v.parent = vFinal;
    	    if (lastTraverseIsLeft){
    	        v.parent.left = v;
    	    } else {
    	        v.parent.right = v;
    	    }
    	    
    	    // System.out.println("parent is "+v.parent.teamNo);
    		
    		
    		
    	    this.rebalance(v.parent);

            // System.out.println("rootVertex:"+rootVertex.teamNo);
            // System.out.println("\n");    		
		    
		}
        vertices.set(teamNo, v);
		
// 		}
	}

	Vertex remove(int teamNo){
		Vertex vertexToRemove = vertices.get(teamNo);
		Vertex leftChild = vertexToRemove.left;
		Vertex rightChild = vertexToRemove.right;
		Vertex parentVertex = vertexToRemove.parent;
		// System.out.println("rootVertex:"+rootVertex.teamNo);

		// System.out.println("removing..."+vertexToRemove.teamNo);

		if (vertexToRemove.duplicateLeader!=-1) {
			if(vertexToRemove.duplicateLeader==vertexToRemove.teamNo){
				Vertex newLeader = vertexToRemove.duplicateVertices.get(0);
				newLeader.right=vertexToRemove.right;
				newLeader.left=vertexToRemove.left;
				newLeader.parent=vertexToRemove.parent;
				vertexToRemove.duplicateVertices.remove(0);
				newLeader.duplicateLeader=newLeader.teamNo;
				newLeader.duplicateVertices=vertexToRemove.duplicateVertices;
				
				if (vertexToRemove.parent != null){
					if(vertexToRemove.parent.left == vertexToRemove){
						vertexToRemove.parent.left = newLeader;
					} else {
						vertexToRemove.parent.right = newLeader;
					}
				}

				if (vertexToRemove.left != null){
					vertexToRemove.left.parent = newLeader;
				}
				if (vertexToRemove.right != null){
					vertexToRemove.right.parent = newLeader;
					// System.out.println("here:"+vertexToRemove.right.parent.teamNo);
				}

				if (vertexToRemove == rootVertex){
					rootVertex=newLeader;
				}

				// System.out.println("duplicateVertices.size:"+newLeader.duplicateVertices.size());
				if(newLeader.duplicateVertices.size()==0){
					newLeader.duplicateLeader=-1;
				}

			} else {
				vertices.get(vertexToRemove.duplicateLeader).duplicateVertices.remove(0);
				
			}



			return vertexToRemove;
		}
		// System.out.println("LC,RC"+leftChild+rightChild);
		if (parentVertex==null){
			Vertex successor = this.getSuccessor(vertexToRemove);
			Vertex tmp = vertexToRemove;

			if (leftChild==null & rightChild==null & rootVertex==vertexToRemove){
				// System.out.println("removing last vertex");
				rootVertex=null;
				// System.out.println("\n");
				return vertexToRemove;
			}
			
			if(successor!=null){
				successor.left = vertexToRemove.left;
				successor.right = vertexToRemove.right;

				// ensure no pointing to self
				if (successor.right == successor){
					successor.right = null;
				} 
				if (successor.left == successor){
					successor.left = null;
				}


				if (successor.parent.left == successor){
					successor.parent.left = null;
				} else {
					successor.parent.right = null;
				}
				

				leftChild.parent = successor;
				rightChild.parent = successor;
				rootVertex = successor;
				// System.out.println("rootVertex:"+rootVertex.teamNo);
				// System.out.println("rebalancing...");
				// System.out.println("successor:"+successor.teamNo);
				// System.out.println("successor.right:"+successor.right);
				// System.out.println("successor.left:"+successor.left);
				successor.parent = null;
				// System.out.println("successor.parent:"+successor.parent);
				this.rebalance(successor);
			} else {
				if (vertexToRemove.left !=null){
					vertexToRemove.left.parent=null;
					rootVertex=vertexToRemove.left;
					this.rebalance(rootVertex);
				}
				// successor.left=null;
				// successor.right=null;
	
			}
		
		} else {
			// System.out.println("parentVertex:"+parentVertex.teamNo);
			// System.out.println("entered");
			if (leftChild == null & rightChild == null){
				// System.out.println("case1"+parentVertex.left+parentVertex.right);
				if (vertexToRemove == parentVertex.left){
					parentVertex.left = null;
				} else {
					parentVertex.right = null;
				}
			} else if (leftChild != null & rightChild == null) {
				// System.out.println("case2");
				if (parentVertex.left == vertexToRemove){
					parentVertex.left = leftChild;
				} else {
					parentVertex.right = leftChild;
				}
				leftChild.parent = parentVertex;

			} else if (leftChild == null & rightChild != null) {
				// System.out.println("case3");
				if (parentVertex.left == vertexToRemove){
					parentVertex.left = rightChild;
				} else {
					parentVertex.right = rightChild;
				}
				rightChild.parent = parentVertex;
			} else if (leftChild != null & rightChild != null) {
				// System.out.println("case4");
				// Vertex successor = this.getSuccessor(vertexToRemove);
				if (parentVertex.left == vertexToRemove){
					parentVertex.left = rightChild;
					rightChild.left = leftChild;
				} else {
					parentVertex.right = rightChild;
					rightChild.left = leftChild;
				}
				rightChild.parent = parentVertex;
				leftChild.parent = rightChild;

			}
			// System.out.println("exited");
			// System.out.println("rebalancing...");
			this.rebalance(parentVertex);
		}

		// System.out.println("\n");

		
		return vertexToRemove;



	}

	void rebalance(Vertex parentVertex){
		// Vertex parentVertex = v.parent;
		int bfChild=-3, bfParent;
// 		int bf = getBalanceFactor(parentVertex);
// 		System.out.println("parent TeamNo:"+parentVertex.teamNo);
// 		System.out.println("parent bf:"+bf);
		// System.out.println("double check parentVertex:"+parentVertex.parent);
		
		while (parentVertex != null){
			// count++;
			// if (count>10){
			// 	break;
			// }
			// System.out.println("count:"+count);
    		bfParent = getBalanceFactor(parentVertex);
    		// System.out.println("parent TeamNo:"+parentVertex.teamNo);
    		// System.out.println("parent bf:"+bfParent);
    		
    		if (bfParent==2){
    		    bfChild = getBalanceFactor(parentVertex.left);
    		  //  System.out.println("child bf:"+bfChild);
    		} else if (bfParent== -2) {
    		    bfChild = getBalanceFactor(parentVertex.right);
    		  //  System.out.println("child bf:"+bfChild);
    		}
    		
    		// rotations
    		// System.out.println("bfParent,bfChild:"+bfParent+bfChild);
    		if(bfParent == 2 & (bfChild >=0 & bfChild <= 1)){
    		    // System.out.println("rotateRight");
    		    rotateRight(parentVertex);
    		} else if (bfParent == 2 & bfChild == -1) {
    		    // System.out.println("rotateLeft,rotateRight");
    		    rotateLeft(parentVertex.left);
    		    rotateRight(parentVertex);
    		} else if (bfParent == -2 & (bfChild >=-1 & bfChild <= 0)){
    		    // System.out.println("rotateLeft "+parentVertex.teamNo);
    		    rotateLeft(parentVertex);
    		    
    		} else if (bfParent == -2 & bfChild == 1){
    		    // System.out.println("rotateRight,rotateLeft");
    		    rotateRight(parentVertex.right);
    		    rotateLeft(parentVertex);
    		}
    		// System.out.println("parentVVVVVVVVVVV"+parentVertex.parent);
    		// System.out.println("current parentVertex:"+parentVertex.teamNo);

    		// if (parentVertex.parent!=null){
	    	// 	System.out.println("current parentVertex.parent:"+parentVertex.parent.teamNo);

    		// }
            parentVertex = parentVertex.parent;
    		
		}
		// return v;
	}

	int getBalanceFactor(Vertex v){
	    
	    if (v.left == null & v.right == null){
	        // System.out.println("bf1");
	        return 0;
	    } else if (v.left == null & v.right != null) {
	    	// System.out.println("bf2");
	        return -1 - v.right.getHeight();
	    } else if (v.left != null & v.right == null) {
	        // System.out.println("bf3");
	        // System.out.println("final height:"+(v.left.getHeight() + 1));
	        return v.left.getHeight() + 1;
	    } else {
	    	// System.out.println("bf4");
	        return v.left.getHeight() - v.right.getHeight();     
	    }
	    
	}
}