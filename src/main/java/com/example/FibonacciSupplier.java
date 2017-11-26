package com.example;
import java.util.function.Supplier;

/**
 * 
 * @author seon
 *
 * 问题：完成一个上台阶的问题，一个人每次可以上1、2或者3级台阶，问10级台阶有多少种上法。
 * 在stream-java8的基础上修改和提交。
 */

public class FibonacciSupplier implements Supplier<Long> {
//  private long previous = 1;
//  private long current = 2;
	private long f = 0;
	private long n = 0;
	private long h = 1;
	private long a ;

  @Override
  public Long get() {
//    long p = previous;
//    long next = current + previous;
//    previous = current;
//    current = next;
//    return p;
		a=f+n+h;
		f= n;
		n=h;
		h=a;
		return a;
  }
}
