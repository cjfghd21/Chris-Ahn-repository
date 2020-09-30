
public class ArraySum {

	public int sumOfArray(Integer[] a, int index) {
		int sum;
		if(index == 0)
			sum = a[0];
		else 
			sum = sumOfArray(a, index - 1) + a[index];
		
		return sum;
	}
}
