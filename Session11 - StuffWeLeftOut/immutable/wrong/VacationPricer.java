/*
 * This example shows a common mistake, using a mutable instance's reference
 * directly in the constructor.
 * This is similar to the Student example, but more subtle.
 */

// Note:  The price variable is extraneous in the example,
// it is only to drive home the impact a fault immutable class can have.

// This class violates point 4 from
// https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html

import java.util.*;
import java.util.concurrent.*;

final class Vacation {

	private Date from;
	private Date to;
	private double priceInDollars;

	public Vacation(Date from, Date to) {
		this.from = from;
		this.to = to;

		long differenceInMs = to.getTime() - from.getTime();

		long noOfDays = TimeUnit.DAYS.convert(differenceInMs, TimeUnit.MILLISECONDS);

		this.priceInDollars = noOfDays * 30;
	}

	public double getPriceInDollars() {
		return priceInDollars;
	}

	@Override
	public String toString() {
		return "Vacation [from=" + from + ", to=" + to + ", price=" + priceInDollars + "]";
	}
}

class VacationPricer {
	public static void main(String[] args) {
		// an example of an awful API
		// Where year has to be 2017 - 1900
		// and months start from 0, so 1 is actually Feb :|
		Date from = new Date(117, 1, 6);
		Date to = new Date(117, 1, 13);

		Vacation v = new Vacation(from, to);
		System.out.println(v);

		// Extend vacation by 1 month!
		to.setMonth(2);

		// Vacation is extended, without any price change!
		System.out.println(v);
	}
}
