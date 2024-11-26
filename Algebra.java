// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(2,3));   // 2 + 3
	    //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		//System.out.println(times(-3,-4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(12,3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Gets two variables X1, X2 and return the sum of X1 + X2
		// Setting varibales
		int a = x1;
		int b = x2;

		if ( b < 0 ){
			for (int i = 0; i > b ; i--){
				a--;
			}
		}else{
			for (int i = 0; i < b ; i++){
				a++;
			}
		}
		return a;

		}
		

	

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Setting varibales
		int a = x1;
		int b = x2;

		//Minus one to a for b times

		if ( b < 0 ){
			for (int i = 0; i > b ; i--){
				a++;
			}
		}else{
			for (int i = 0; i < b ; i++){
				a--;
			}
		}
		return a;
	}
	

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		//Get two vvariable X1, X2 and return the multiplaction of X1 * X2
		// Setting varibales
		int a = x1;
		int b = x2;
		int sum = a;
		
		if (a == 0 || b == 0){
			sum = 0;
		}else if (a > 0 && b > 0){
			for (int i = 1; i < b; i++){
				sum = plus(sum,a);
			}
		}else if( a < 0 && b > 0 ){
			for (int i = 1; i < b; i++){
				sum = plus(sum,a);
			}
		}else if( a > 0 && b < 0){
			sum = b;
			for (int i = 1; i < a; i++){
				sum = plus(sum,b);
			}
		}else{
			for (int i = -1; i > b; i--){
				sum = plus(sum,a);
			}
			sum = -sum;
		}
			

		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Setting varibales
		int a = x;
		int b = n;
		int sum = a;

		if (b == 0){
			sum = 1;
			return sum;
		}

		for (int i = 0; i < b - 1 ; i++){
			sum = times(sum, a);
		}

		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code

		int a = x1;
		int b = x2;
		int sum = b;
		int divider = 1;
		if (a == 0) {
			divider = 0;
		}
		else if(a < 0 && b < 0){
			a = times(a, -1);
			b = times(b, -1);
			while(sum <= a-b){
				divider++;
				sum = times(divider,b);
			}
		}else if(a < 0 && b > 0){
			a = times (a, -1);
			while(sum <= a-b){
				divider++;
				sum = times(divider,b);
			}
			divider = times(divider, -1);
		}else if( a > 0 && b < 0){
			b = times (b, -1);
			while(sum <= a-b){
				divider++;
				sum = times(divider,b);
			}
			divider = times(divider, -1);
		}else{
			while(sum <= a-b){
				divider++;
				sum = times(divider,b);
			}
		}
			return divider;
			
		}


	// Returns x1 % x2
	public static int mod(int x1, int x2) {

		int a = x1;
		int b = x2;
		int output = 0;

		output = minus(a, times(b, div(a,b)));


		return output;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int a = x;
		int num = 0;
		int pow_check = 0;

		pow_check = pow(num,2);

		while (pow_check < a){
			num ++;
			pow_check = pow(num,2);
		}
		if (pow_check != a){
			num = minus(num, 1);
		}
		return num;
	}	  	  
}