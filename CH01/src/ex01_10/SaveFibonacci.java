package ex01_10;

public class SaveFibonacci {
	
	public int fibnum;
	public boolean even;
	
	public SaveFibonacci(int num){
		fibnum = num;
		if(num % 2 == 0){
			even = true;
		}
		else{
			even = false;
		}
	}
}
