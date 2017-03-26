# Session 4

## Table of Contents
1. [Revision](#session3-revise)
2. [Initializer Blocks](#initializer)
    1. [Instance Initializer Block](#instance-initializer)
    2. [Static Initializer Block](#static-initializer)
2. [Call Stack](#call-stack)
3. [Object Heap](#object-heap)
4. [Some Traps and Pitfalls](#traps)
	1. [Compiler Evaluations](#compiler)
	2. [String Interning](#string-intern)
5. [Recursion And Memoization Practice](#recursion)
6. [BufferedReader - The Faster Way Of Accepting Input](#buffered-reader)
6. [Assignments](#assignments)
    1. [HackerRank](#hackerrank)
    2. [Miscellaneous](#miscellaneous)

### <a name="session3-revise"></a>Revision

1. A class is a blueprint for defining a real or abstract concept. Examples of classes are `Person`, `Student`, `Employee`, `Shape`, `Stack`, etc.
2. An instance variable is a property of each instance of the class. For example, _each_ `Person` instance will have a `name` (String), an `age` (int), and `height` (double). these properties typically distinguish one instance of a class from another instance.
3. A static variable is a property of the class as a whole. All instances of the class share the static variable. eg: `Math.PI`
4. An instance method is a function that belongs to an instance of the class. For example, _each_ instance of the Person class will have a method called `growOld()` or `drinkComplan()`:
5. A static method is a function that belongs to the class as a whole. This is typically done when it doesn't make sense for each instance to have the method. For example, functions like GCD, isPrime, etc do not belong to any one instance of any class.
6. The `final` keyword prevents the variable from being assigned a value after it has been initialized.

Example:

```java
class Person {
	// instance variables
	String name;
	int age;
	double height;
	
	final int yearOfBirth;	// Because obviously your birth year cannot change
	
	// Parameterized constructor
	Person(String n, int a, double h, int y) {
		name = n;
		age = a;
		height = h;
		yearOfBirth = y;
	}
	
	// Instance method
	void drinkComplan() {
		height += 0.1;
	}
}

class ComplanAdvertisement {
	public static void main(String[] args) {
	
		Person p = new Person("Peter", 18, 5.1, 1999);
		System.out.println(p.getHeight());			//	Prints out 5.1

		p.drinkComplan();
		System.out.println(p.getHeight());			//	Prints out 5.2
	}
}
```

### <a name="initializer"></a>Initializer Blocks
There are two types of initializer blocks in Java.

1. Instance Initializer Block  
As the name suggests, it is used to initialize instance variables.
Example:

```java
class Person {
	int age;
	
	{
		age = 18;
	}
}
```

The initializer block's content is copied into **every** constructor by the compiler. This means that you can initialize final variables in the instance initializer block as well. 

2. Static Initializer Block  
This is executed once for each class.

```java
class MathExample {
	static double pi;
	
	static {
		pi = 3.14;
	}
}
```

You are allowed to put arbitrary statements inside initializer blocks.
Initializer blocks are a _slightly_ advanced concept, and so it is sufficient for you to understand and remember the above, without worrying too much about internal details of their working.

### <a name="call-stack"></a>Call Stack

TODO

### <a name="object-heap"></a>Object Heap

TODO

### <a name="traps"></a>Some Traps and Pitfalls

TODO

### <a name="recursion"></a>Recursion And Memoization Practice

TODO

### <a name="buffered-reader"></a>BufferedReader - The Faster Way Of Accepting Input

As you may have noticed when solving last session's String problems, Scanner has a slight drawback, i.e. it does not play well when you intertwine calls of sc.next() and numeric input (sc.nextInt(), sc.nextDouble(), etc)  

In addition, it also has the drawback of being slightly slow. When you start solving problems on CodeChef, using Scanner will almost always result in timeouts. As a replacement, you can use BufferedReader. Below is a complete example of how to use BufferedReader to accept and transform numerical input:

Imagine that the input format is:  
1. The first number is the number of test cases T, 1 <= T <= 100
2. 2*T lines follow, 2 lines per test case.  
	1. The first line is the number of elements in the array
	2. The second is an array of integers.

```java
class BufferedReaderExample {
	// Note the "throws IOException"
	// Not writing those lines will end up in a compiler error
	// We will see Exceptions in detail in a future session
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// br.readLine() returns a single String, which is the current line of input
		String s = br.readLine();
		int T = Integer.parseInt(s);	
		
		// Similar methods are Long.parseLong(), Double.parseDouble(), etc
		
		while (T != 0) {
			// You can do it in a single line as well
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			
			// br.readLine() would result in a String which looks something like "1 2 3 10 5 4"
			// Split returns an array of strings, depending on the delimiter, which is mostly a space
			// sa now has {"1", "2", "3", "10", "5", "4"}
			String[] sa = br.readLine().split(" ");
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(sa[i]);
			}
			
			// Do usual stuff with arr
			
			T--;
		}
	}
}
```

### <a name="assignments"></a>Assignments 

#### <a name="hackerrank"></a>HackerRank
1.	https://www.hackerrank.com/challenges/hackerrank-in-a-string  
2.	https://www.hackerrank.com/challenges/weighted-uniform-string  
3.	https://www.hackerrank.com/challenges/red-john-is-back  
4.	https://www.hackerrank.com/challenges/stockmax (HARD)  
5.	https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array  
6.	https://www.hackerrank.com/challenges/grid-challenge  
7.	https://www.hackerrank.com/challenges/luck-balance  
8.	https://www.hackerrank.com/challenges/maximum-perimeter-triangle  
9.	https://www.hackerrank.com/challenges/priyanka-and-toys  
10.	https://www.hackerrank.com/challenges/mark-and-toys  
11.	https://www.hackerrank.com/challenges/angry-children

#### <a name="miscellaneous"></a>Miscellaneous
TODO
