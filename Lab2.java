import java.util.*;	



public class Lab2{
	public static int char2int(char charIdx) {
		int[] intMap={
			2,22,222,
			3,33,333,
			4,44,444,
			5,55,555,
			6,66,666,
			7,77,777,7777,
			8,88,888,
			9,99,999,9999};

		int asciiValue = Character.getNumericValue(charIdx);

		// shift to start at 'a'
		asciiValue = asciiValue - 10; 
		
		return intMap[asciiValue];
	}

	public static int whichKeypad(int intInput){
		return intInput % 10; 
	}

	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int caseNo = sc.nextInt();
		String nextLineCatcher = sc.nextLine();
		//String sentence = sc.nextLine();
		int intOfChar;
		int prevKeypad = -1; // initialise to -1 (-1 is randomly chosen)
		int keypadPressed=-1;
		
		for (int currentCase = 1 ; currentCase <= caseNo; currentCase++) {
			
			String sentence = sc.nextLine();
			System.out.print("Case #"+currentCase+": ");


			char currentChar;
			
//			System.out.println("doing:" + sentence);

			for (int charIdx = 1; charIdx<=sentence.length(); charIdx++) {
				currentChar = sentence.charAt(charIdx-1);
				if (currentChar == ' '){
					keypadPressed = 0;
					if (prevKeypad == keypadPressed) {
						System.out.print(" 0");
						//System.out.println("prev:"+prevKeypad + " now:"+keypadPressed);
					} else {
						System.out.print("0");
					}
					prevKeypad = 0;
				} else {
					intOfChar = char2int(currentChar);
					keypadPressed = whichKeypad(intOfChar);
					if (prevKeypad == keypadPressed){
						System.out.print(" "+intOfChar);

					}else{
						System.out.print(intOfChar);

					}
					prevKeypad = whichKeypad(intOfChar);
				}
			}
			System.out.print("\n");
			//sentence=sc.nextLine();

			//nextLineCatcher = sc.nextLine();
		}
	}
}