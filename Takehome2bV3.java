import java.io.*;
import java.util.*;

public class Takehome2bV3{
	public static void main (String [] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		try {
			// initialise
			int opTotal = Integer.parseInt(br.readLine());
			String[] instr;
			String action;
			int operand;
			Jiayilist list1 = new Jiayilist();
			Jiayilist list2 = new Jiayilist();
			ArrayList<Integer> numToPrint = new ArrayList<Integer>();
			int[] arr1= new int[opTotal];
			int[] arr2= new int[opTotal];

			// parse instructions
			for (int opCount = 0; opCount < opTotal; opCount++){
				instr = br.readLine().split(" ");
				action = instr[0];
				operand = Integer.parseInt(instr[1]);

				// execute pushing
				if (action.equals("push_back")){
					list2.addLast(operand);
					
				} else if (action.equals("push_front")) {
					list1.addFirst(operand);
				} else if (action.equals("push_middle")) {
					list2.addFirst(operand);
				} else if (action.equals("get")){
					if ((operand+1)>list1.size()){
						numToPrint.add(list2.get(operand-list1.size()));

					} else{
						numToPrint.add(list1.get(operand));
					}
				}

				// rebalance list1 and list 2
				if(list2.size() - list1.size() >= 1){
					list1.addLast(list2.removeFirst());
				} else if (list1.size() - list2.size() >= 2) {
					list2.addFirst(list1.removeLast());
				}

				System.out.println("list1: "+list1.toString());
				System.out.println("list2: "+list2.toString());		
				System.out.println("toPrint: "+numToPrint.toString());
				System.out.println();
					
				

			}

			// print requested info
	        OutputStream out = new BufferedOutputStream ( System.out );
	        // for (int i = 0; i < 100000; i++) {
	        //     out.write((i + "\n").getBytes());
	        // }
	        // out.flush();

			for (int printCount = 0; printCount < numToPrint.size(); printCount++){
				// System.out.println(numToPrint.get(printCount));
				out.write((numToPrint.get(printCount) + "\n").getBytes());
			}
			out.flush();
		} catch (IOException e) {
			
			e.printStackTrace();

		} finally {
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}

class Jiayilist extends LinkedList <Integer>{

	public int[] arr;
	public int midIndex;



	public void push_back(int operand){
		this.addLast(operand);
	}

	public void push_front(int operand){
		this.addFirst(operand);
	}

	// public void push_middle(int operand){
	// 	this.add(this.midIndex, operand);
	// 	this.midIndex = (this.size()+1)/2;
	// }

}