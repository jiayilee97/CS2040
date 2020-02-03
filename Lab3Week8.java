import java.util.*;

public class Lab3Week8{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int resNo = sc.nextInt();
		int durForLock = sc.nextInt();
		String nextLineCatcher = sc.nextLine();
		int[][] workStationStates = new int [resNo][3];	
		PriorityQueue<WorkStation> pqueue1 = new PriorityQueue<>(resNo, new pqueueSorter());

		int[][] resInfo = new int[resNo][2];

		// read input
		for (int resCount=0; resCount<resNo; resCount++){
			resInfo[resCount][0]=sc.nextInt();
			resInfo[resCount][1]=sc.nextInt();
			nextLineCatcher=sc.nextLine();
		}

		// sort the researchers by arrival time
		Arrays.sort(resInfo, new sortByX());

		int newID=0;
		int timeDiff;
		boolean inserted = false;
		int saves=0;
		
		for (int resCount=0; resCount<resNo; resCount++){
			inserted=false;
			while(inserted==false){

				if (pqueue1.peek()==null) { 
				// if pqueue is empty, add new workstation
					pqueue1.add(new WorkStation(
						newID, 
						resInfo[resCount][0], 
						resInfo[resCount][1], 
						durForLock));
					newID++;
					inserted = true;
				} else {	
				// if pqueue is not empty, try to assign workstations 
					timeDiff=pqueue1.peek().expiryTime
						- resInfo[resCount][0];

					if (timeDiff < 0){
						// check if workstation is already locked, remove it
						newID=pqueue1.poll().id;
					} else if (timeDiff <=durForLock) {
						// if workstation is unused and idle, use it
						pqueue1.add(pqueue1.poll().setNewParam(
							resInfo[resCount][0],
							resInfo[resCount][1],
							durForLock));
						saves++;
						inserted = true;
					} else if (timeDiff > durForLock) {
						// if all workstations are occupied, add a new one
						pqueue1.add(new WorkStation(
							newID, 
							resInfo[resCount][0], 
							resInfo[resCount][1], 
							durForLock));
						newID++;
						inserted = true;
					}

					
				}

			}

		}
		
		System.out.println(saves);
	}
}

class WorkStation{
	public int id, startTime, expiryTime;

	public WorkStation(int id, int startTime, int durUsed, int durForLock){ 
		this.id = id;
		this.expiryTime=durForLock+startTime+durUsed;
	}

	public WorkStation setNewParam(int startTime, int durUsed, int durForLock){
		this.expiryTime= startTime + durUsed + durForLock;
		return this;
	}

}

class sortByX implements Comparator<int[]>{
	public int compare (int[] ar1, int[] ar2){
		return ar1[0] - ar2[0];
	}
}

class pqueueSorter implements Comparator<WorkStation>{
	public int compare (WorkStation ws1, WorkStation ws2){
		return ws1.expiryTime - ws2.expiryTime;
	}
}