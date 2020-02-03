import java.util.*;

public class Lab4{
	public static void main(String[]args){

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();

		// Start algorithm
		for(int currentTestCase=1; currentTestCase<=testCases; currentTestCase++){
			String nextLineCatcher = sc.nextLine();
			LinkedList list1=new LinkedList();

			int n = sc.nextInt();
			list1.add(n);

			// Reverse move the pack of cards
			for(int numToAdd=n; numToAdd >= 2; numToAdd--){
				for(int numOfMoves=1; numOfMoves<=numToAdd; numOfMoves++){
					list1.add(list1.removeFirst());
				}
				list1.add(numToAdd-1);
			}

			// Add next card
			list1.add(list1.removeFirst());

			// Print the order of cards
			for(int printIndex=(list1.size()-1); printIndex>=0; printIndex--){
				System.out.print(list1.get(printIndex));
				if (printIndex>0){
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}

		}


	}
}