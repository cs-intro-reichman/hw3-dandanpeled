// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter = 0;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		// Replace the following statement with your code
		double R = rate;
		int periods = n;
		double P = payment;
		double end_sum = loan;
		
		for (int i = 0; i < periods; i++){
			end_sum = (end_sum - P)*(1+R/100);
		}
		
		return end_sum;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		 
		double L = loan;
		double R = rate;
		int periods = n;

		double pay = L/periods;
		double e = epsilon;
		double balance = 0.0;
		iterationCounter = 0;

		//System.out.println("Firzt pay: "+ pay);
		balance = endBalance(L, R, periods, pay);
		//System.out.println("Firzt balance: "+ balance);

		while (balance > 0){
			pay = pay + e;
			iterationCounter++;
			balance = endBalance(L, R, periods, pay);
		}
		
		return pay;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double L = loan;
		double R = rate;
		int periods = n;

		double upper_bound_pay = L;
		double lower_bound_pay = L/periods;
		double e = epsilon;
		iterationCounter = 0;
		double mid_pay = 0.0;

		while ((upper_bound_pay - lower_bound_pay) > e) {
			mid_pay = (upper_bound_pay+lower_bound_pay)/2;
			iterationCounter++;

			double mid_balance = endBalance(L, R, periods, mid_pay);			
			double low_balance = endBalance(loan, rate, n, lower_bound_pay);

			if ((mid_balance * low_balance) > 0){ 

				lower_bound_pay = mid_pay;

			}else{

				upper_bound_pay = mid_pay;
			}

		}

		return mid_pay;

			
	}

	
		
    }
