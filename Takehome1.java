import java.util.*;

public class Takehome1{
	public static void main(String[] args){
		Scanner sc =  new Scanner(System.in);
		int trainCapacity = sc.nextInt();
		int stationNo = sc.nextInt();
		String nextLineCatcher = sc.nextLine();
		int leftNo;
		int enterNo;
		int stayNo;
		Boolean possibleFlag = true;
		int trainCurrentLoad = 0;
		int trainHypotheticalLoad = 0;
		int excessNo;

		for(int currentStation = 0; currentStation < stationNo; currentStation++){
			leftNo = sc.nextInt();
			enterNo = sc.nextInt();
			stayNo = sc.nextInt();

			// Check if train arrives empty at 1st station
			if (currentStation == 0){
				if (leftNo != 0) {
					possibleFlag = false;
					// System.out.println("train does not arrive empty at 1st station");

				}

			} 

			// Start checking
			trainHypotheticalLoad = trainCurrentLoad - leftNo + enterNo + stayNo;
			if (trainHypotheticalLoad > trainCapacity){
				excessNo = trainHypotheticalLoad - trainCapacity;
				trainCurrentLoad = trainCapacity;
				if (excessNo != stayNo){
					possibleFlag = false;
					// System.out.println("excessNo does not match stayNo");
				}
			} else {
				trainCurrentLoad = trainCurrentLoad - leftNo + enterNo; 
				if (stayNo != 0){
					possibleFlag = false;
				}
			}

			// Check if train leaves empty at last station
			if (currentStation == stationNo - 1) {
				if (trainCurrentLoad != 0){
					possibleFlag = false;
					// System.out.println("train does not leave empty");
				}

				
			}

			// System.out.println("trainCurrentLoad: " + trainCurrentLoad);
			nextLineCatcher = sc.nextLine();

		}

		if (possibleFlag){
			System.out.println("possible");
		} else {
			System.out.println("impossible");
		}



	}
}