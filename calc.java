import java.util.Stack;
import java.util.ArrayList;


class Calculator{
  /*Basic RPN calculator
  	- on CLI enter commands like "0 3 4 5 - x +" */

  Stack<Integer> inputs;
  
  public Calculator() {
  	// Initialize with just the stack
  	inputs = new Stack<Integer>();
  }

  public void entry(int num) {
  	// Controlling access to internal variables
  	inputs.push(num);
  }

  public int sum() {
  	// Pull last two elements from stack and sums
  	// Pushes back to stack and returns value 
    int a = inputs.pop();
    int b = inputs.pop();
    int c = a + b;
    inputs.push(c);
    return c;
  }
  
  public int diff() {
  	// Pull last two elements from stack and subtracts
  	// Pushes back to stack and returns value
  	int a = inputs.pop();
  	int b = inputs.pop();
  	int c = a - b;
  	inputs.push(c);
  	return c;
  }

  public int mult() {
  	// Pull last two elements from stack and subtracts
  	// Pushes back to stack and returns value
  	int a = inputs.pop();
  	int b = inputs.pop();
  	int c = a * b;
  	inputs.push(c);
  	return c;
  }

  public int div() {
  	// Pull last two elements from stack and subtracts
  	// Pushes back to stack and returns value
  	int a = inputs.pop();
  	int b = inputs.pop();
  	int c = a / b;
  	inputs.push(c);
  	return c;
  }




	public static void main(String[] args) {
		Calculator rpn = new Calculator();
		Integer num;
		Integer tmp_res;
		ArrayList<String> operations = new ArrayList<String>();
		for (String arg: args){
			try {
				num = Integer.parseInt(arg);
				rpn.entry(num);
			}

			catch (NumberFormatException nfe) {
				operations.add(arg);
			}
		}
		for (String item: operations) {
			if ("+".equals(item)) {
				tmp_res = rpn.sum();
			}
			else if ("-".equals(item)) {
				tmp_res = rpn.diff();
			}
			else if ("x".equals(item)) {
				tmp_res = rpn.mult();
			}
			else if ("/".equals(item)) {
				tmp_res = rpn.div();
			}
			else {
				tmp_res = 0;
			}
			System.out.println(tmp_res);
		}

		/*rpn.entry(5);
		rpn.entry(3);
		rpn.entry(9);
		rpn.entry(6);
		System.out.println(rpn.sum());
		System.out.println(rpn.mult());
		System.out.println(rpn.div());*/
	}
}