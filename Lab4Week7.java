import java.util.*;

public class Lab4Week7{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		HashMap <String,Integer> map1 = new HashMap<>();
		LinkedList <Integer> comboX = new LinkedList<Integer>();

		int froshTotal = sc.nextInt();
		String nextLineCatcher = sc.nextLine();
		String[] comboInt = new String[5];
		String comboJoined;

		for(int froshCount = 0; froshCount < froshTotal; froshCount++){
			// read one line of course combination
			for (int id=0; id<5; id++){
				comboInt[id]= sc.next();
			}

			// standardise combination
			Arrays.sort(comboInt);
			comboJoined=String.join("",comboInt);

			// put into hash
			if (map1.containsKey(comboJoined)){
				map1.put(comboJoined, map1.get(comboJoined)+1);
			} else {
				map1.put(comboJoined,1);
			}
			// System.out.println("current:"+map1.toString());

			// catch \n
			nextLineCatcher = sc.nextLine();

		
		}

		// find most popular amount
		int mostPopularAmt=-1;
		for(String key : map1.keySet()){
			if (map1.get(key) >= mostPopularAmt){
				mostPopularAmt = map1.get(key);

			}
		}

		// count combination with most popular amount
		int mostPopularCount=0;

		for(String key : map1.keySet()){
			if (map1.get(key) == mostPopularAmt){
				mostPopularCount = mostPopularCount + mostPopularAmt;
			}			
		}		
		
		// account for scenario where all combination are unique
		if(mostPopularAmt==1){
			System.out.println(froshTotal);
		} else {
			System.out.println(mostPopularCount);

		}

		// close scanner
		sc.close();
	}
}