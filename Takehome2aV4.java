import java.util.*;
import java.io.*;

public class Takehome2aV4{
	public static void main(String [] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		


		try{
			int wordCount = Integer.parseInt(br.readLine());

			
			String[] words = new String[wordCount];		
			for (int wordNo=0; wordNo<wordCount; wordNo++){
				words[wordNo] = br.readLine();
				
			}

			int operationCount = wordCount-1;
			int[][] opArr = new int[operationCount][2];
			String[] parts=new String[2];
			String inputOp;
			int op1=-1,op2;
			int[] indexToUpdate= new int[wordCount];
			int[] nextEle= new int[wordCount];

			ArrayList<ArrayList<Integer>> arrlist2=new ArrayList<>();

			// initialise array
			for (int i=1; i<=wordCount; i++){
				ArrayList<Integer> arrX = new ArrayList<>();
				arrX.add(i);
				arrlist2.add(arrX);
			}
			// System.out.println("arr:"+arrlist2.toString());

			OutputStream out = new BufferedOutputStream ( System.out );

			if (wordCount==1){
				out.write((words[0]).getBytes());
				out.flush();
			}
			else{
			int i1,i2;
			int head=0, tail=0;
			for (int i=0; i<indexToUpdate.length;i++){
				indexToUpdate[i]=i+1;
			}
			// System.out.println("i:"+Arrays.toString(indexToUpdate));
			if (operationCount>0){
				for (int wordNo=0; wordNo<operationCount;wordNo++){

					inputOp=br.readLine();
					parts=inputOp.split(" ");
					op1=Integer.parseInt(parts[0]);
					op2=Integer.parseInt(parts[1]);
					

					i1=indexToUpdate[op1-1];

					nextEle[i1-1]=op2;
					indexToUpdate[op1-1]=indexToUpdate[op2-1];
					// System.out.println("indexToUpdate:"+Arrays.toString(indexToUpdate));
					// System.out.println("nextEle:"+Arrays.toString(nextEle));

					head = op1;
					tail = indexToUpdate[op1-1];
				}

				int index=head;
				while(index!=0){
					out.write((words[index-1]).getBytes());
					if (index==tail) {
						break;
					}
					index=nextEle[index-1];

				}

			} else {
				// out.write((words[0]).getBytes());
			}
				out.flush();
				// System.out.println("\nflushed");



			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}