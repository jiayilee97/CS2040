import java.util.*;	
// java Lab1 < 1.in > output.output
// vim: ESC then type :wq to save or :q to exit without saving

public class Lab1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int restNo = sc.nextInt();
		int menuNo;
		String currentMenuName;
		String output = "Anywhere is fine I guess";
		String currentRestName;
		String newLineCatcher;
		Boolean outputFound = false;
		Boolean pancakeFound = false;
		Boolean peasoupFound = false;

		// Process the restaurants
		for (int currentRestNo = 1; currentRestNo <= restNo ; currentRestNo++ ) {
			menuNo = sc.nextInt();
			newLineCatcher = sc.nextLine();
			currentRestName = sc.nextLine();

			for (int currentMenuNo = 1; currentMenuNo <= menuNo ; currentMenuNo++ ) {
				currentMenuName = sc.nextLine();
				if (outputFound == false) {
					if (currentMenuName.equals("pancakes") || currentMenuName.equals("pea soup")	) {
						if (currentMenuName.equals("pancakes")){
							pancakeFound = true;
						}
						else if (currentMenuName.equals("pea soup")) {
							peasoupFound = true;
						}

						if (pancakeFound && peasoupFound){
							output = currentRestName;
							outputFound = true;
						}
					}

				}
				//System.out.println("menuNo:"+menuNo + " currentRestName:" + currentRestName + " currentMenuNo:" + currentMenuNo + " currentMenuName:" + currentMenuName + " output:" + output);
			}
			peasoupFound = false;
			pancakeFound = false;
		}

		System.out.println(output);
	}


}