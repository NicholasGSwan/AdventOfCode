
public class SpiralMemory {

	static int[] returnRingNumber(int n) {
		int ringNumber = 0;
		int valueOfI = 0;
		int[] ringInfo = new int[6];
		for(int i = 1; i<n ; i += 2) {
			if(Math.pow(i, 2) >= n) {
				valueOfI = i;
				double lowerRightCorner= Math.pow(i, 2);
				int differenceBetweenCorner = (int)lowerRightCorner - n;
				int fromCenter = 0;
				
				int perimeterOfTheRectangle = ringNumber * 2 + 1;
				if(differenceBetweenCorner>= ringNumber && differenceBetweenCorner < perimeterOfTheRectangle) {
					fromCenter = differenceBetweenCorner - ringNumber;
				}else if(differenceBetweenCorner<ringNumber) {
					fromCenter = differenceBetweenCorner;
				}else {
					System.out.println("fuck");
				}
				int steps = fromCenter + ringNumber;
				
				ringInfo[0] = ringNumber;
				ringInfo[1]= valueOfI;
				ringInfo[2] = perimeterOfTheRectangle;
				ringInfo[3] = differenceBetweenCorner;
				ringInfo[4] = fromCenter;
				ringInfo[5] = steps;
				return ringInfo;
			}
			ringNumber++;
		}
		
		return ringInfo;
	}
	
	
	public static void main(String[] args) {
		int[] print = returnRingNumber(312051);
		System.out.println("It's on ring number " + print[0] + " and the value of i is "+ print[1] +". The Perimeter of the Rectangle is "+ print[2]+ " and your number is " +print[3]+ " from the lower right corner " + print[4] + "is the distance from center " + print[5]+ " should be the number of steps"  );
	
		
	}
}
