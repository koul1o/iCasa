package maxSum;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import com.example.bimary.follow.me.ClosestSumAlgorithm;

public class Test {

	public static void main(String[] args) {
		double[] items = new double[] { 1.54d, 7.4d, 3.4d, 8.3d, 15.233d, 99d, 22d, 76d, 38d, 22d, 7d, 0.10d, 54.9d,
				45.9d, 90d, 48.6d, 6.1d, 4.2d, 89.3d };

		// Targeted sum :
		double maxSum = 99.97484;
		// Compute the best combination :
		double[] result = ClosestSumAlgorithm.greadySubSetClosestSum(maxSum, items);
		System.out.println(Arrays.toString(result));
		double sum = DoubleStream.of(result).sum();
		System.out.println("sum= " + sum);

	}
}
