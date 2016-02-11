package realgh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Functions {
	
	public int R,C,D,T,P,PT,O,W; //Rows, Columns, Drones, Turns, Payload, ProductType, Orders, number of Warehouses
	int[] PW; //Package Weight
	int[][] WS; //Warehouse Storage
	int[][] WC; //Warehouse Coordinates
	Order[] ORDLIST; //Orders
	
	
	
	public void readInput(){
		
		try {
			Scanner in = new Scanner(new FileReader(""));
			R = in.nextInt();
			C = in.nextInt();
			D = in.nextInt();
			T = in.nextInt();
			P = in.nextInt();
			PT = in.nextInt();
			
		
			
			for(int i = 0; i < PT; i++){
				PW[i] = in.nextInt();
				
			}
			
			W = in.nextInt();
			
			for(int j = 0; j < W; j++){
				WC[j][0] = in.nextInt();
				WC[j][1] = in.nextInt();
				
			}
			
			for(int z = 0; z < PT; z++){
				WS[z][0] = in.nextInt();
			}
			
			O = in.nextInt();
			
			for(int a = 0; a < O; a++){
				ORDLIST[a]= new Order(in.nextInt(),in.nextInt());
				int numItems = in.nextInt();
				for(int b = 0; b < numItems; b++){
					ORDLIST[b].addItem(in.nextInt());
				}
			}
			
			in.close();
		
		}catch(FileNotFoundException e) { 
            System.out.println("Could not open file due to"); System.out.println(e); 
            return;
	}
}	

	
	
	public class Order {
		
		int R,C;
		int[] items = new int[PT];
		boolean teken = false;
		
		public Order(int r, int c){
			R = r;
			C = c;
			for(int i = 0; i < PT; i++){
				items[i] = 0;
			}
		}
		
		public void addItem(int t){
			items[t]++;
		}
	}
}
