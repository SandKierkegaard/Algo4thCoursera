package chap1;
//input args[0] =h, print a pyramid of height h

public class Pyramid {

	public static void main(String[] args) {
		int h = Integer.parseInt(args[0]);
		for(int i=1;i<=h;i++){
			for(int T=1;T<2*h;T++){
				if(Math.abs(T-h)>=i){
					System.out.print("      ");
				}
				else
					System.out.printf("%6d",((int)Math.pow(2,i-Math.abs(T-h)-1)));
			}
		System.out.println();
		}
	}

}
