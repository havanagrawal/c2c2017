# Session 1

## Table of Contents
1. [Intro to Java](#intro)
    1. [What is Java](#what-is-java)
    2. [Flavors of Java](#flavors)
    3. [Compilation of a Java file](#compilation)
    4. [Naming Conventions](#conventions)
    5. [Hello, World](#hello)
    6. [Primitive Data Types](#primitives)
2. [Some Real Coding](#some-real-coding)
    1. [Conditionals](#conditionals)
    2. [Conditionals practice](#conditionals-practice)
    3. [Loops](#loops)
    4. [Loop practice](#loops-practice)
3. [Assignments](#assignments)

### <a name="intro"></a>Intro to Java 
#### <a name="what-is-java"></a> What is Java?
1. A programming language
2. Object oriented
3. WORA (Write-Once-Read-Anywhere)
 
#### <a name="flavors"></a>Flavors of Java
1. ME - Mobile Edition, 
2. SE - Standard Edition
3. EE - Enterprise Edition

#### <a name="compilation"></a>Compilation of a java file
JDK, JRE, JVM, bytecode

#### <a name="conventions"></a>Naming Conventions
Variables and functions: `camelCase`  
Examples: `noOfCats`, `scanner`, `totalSalary`, `getAmount`

Classes: `PascalCase`  
Examples: `SampleJavaApplication`, `CodeChefSolution`

#### <a name="hello"></a>Hello World

```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

`System`, `out`, and `println`
Signature of a function, signature of `main`

#### <a name="primitives"></a>Primitive data types
Primitives in Java (`byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`) and their ranges

| Primitive Data Type | Size (bytes)           | Size (bits) | Range                                                       | Range in powers of 2                  |
|---------------------|------------------------|-------------|-------------------------------------------------------------|---------------------------------------|
| byte                | 1 byte                 | 8           | -128 to 127                                                 | -2<sup>7</sup> to 2<sup>7</sup> - 1   |
| short               | 2 bytes                | 16          | -32,768 to 32,767                                           | -2<sup>15</sup> to 2<sup>15</sup> - 1 |
| int                 | 4 bytes                | 32          | -2,147,483,648 to 2,147,483, 647                            | -2<sup>31</sup> to 2<sup>31</sup> - 1 |
| long                | 8 bytes                | 64          | -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807     | -2<sup>63</sup> to 2<sup>63</sup> - 1 |
| float               | 4 bytes                | 32          | ~ ±3.40282347E+38F (6-7 significant decimal digits)         | -                                     |
| double              | 8 bytes                | 64          | ~ ±1.79769313486231570E+308 (15 significant decimal digits) | -                                     |
| char                | 2 byte                 | 16          | 0 to 65,536 (unsigned)                                      | 0 to 2<sup>16</sup> - 1               |
| boolean             | not precisely defined* | -           | true or false                                               | -                                     |

Arithmetic operations: `+`, `-`, `*`, `/`, `%`  
Shorthand operations: `++`, `--`, `+=`, `-=`, `*=`, `/=`, `%=`  
Comparative ops: `<`, `>`, `<=`, `>=`, `==`, `!=`  
Logical ops: `&&`, `||`  
Bitwise ops: `&`, `|`, `^`, `>>`, `<<`  
Short-circuit behaviour  
Ternary operator `condition ? value1 : value2`  

Implicit and explicit casting  
Casting from and to different data types  
Be careful with shorthand notation (`+=`, `-=`) because of implicit casting  
Be careful with floating point precision  

### <a name="some-real-coding"></a>Some real coding 
Input using `Scanner` class

```java
Scanner sc = new Scanner(System.in);
```

Practice:  

1. Take n, print sum of first n numbers  
2. Take k, print sum of first k odd numbers  
3. Take k, print sum of first k even numbers

#### <a name="conditionals"></a>Conditionals:

##### if-else

```java
if (<boolean-expression>) {
    // do stuff
}
```

```java
if (<boolean-expression>) {
    // do stuff
}
else {
    // do some other stuff
}
```

```java
if (<boolean-expression>) {
    // do stuff
}
else {
    if (<some-other-condition>) {
        // do something 
    }
    else {
        // do something else
    }
}

// Equivalent
if (<boolean-expression>) {
    // do stuff
}
else if (<some-other-condition>) {
    // do something 
}
else {
    // do something else
}
```

Some fun with if conditions.  
Are these possible  
`i > i + 1`  
`i == i + 1`  
`i != i + 0`  

##### switch-case

Typically useful when checking specific values on a variable

```java
int c = sc.nextInt();
switch(c) {
    case 2: System.out.println("Wow");
            break;
    case 0: int k = 5;
            System.out.println("Look ma, no braces");
            break;
    case 4: System.out.println("I don't even need to be in order");
            break;
    default:
            System.out.print("You're out of luck");
            break;
}
```

Remember that switch has fallthrough logic, so once a case matches, it will execute all following cases as well. E.g:

```java
int i = sc.nextInt() % 3;
switch(i) {
    case 0: System.out.println("I am divisible by 3");
    case 1: System.out.println("I am not divisible by 3");
    case 2: System.out.println("I am not at all divisible by 3");
}
```

If you were to enter 3 (or any multiple of 3), it will print:
> I am divisible by 3  
> I am not divisible by 3  
> I am not at all divisible by 3

This is why you need to remember to put the `break;` statements in each case.

You can skip the default case, but it is better to include it.


##### <a name="conditionals-practice"></a>Practice:  
1.	https://www.hackerrank.com/challenges/compare-the-triplets  
	
#### <a name="loops"></a>Loops

There are three styles of looping  
1. for  
2. while  
3. do-while  
 

##### for

```java
for (<initialization>;<condition>;<update>) {
	// do stuff
}
```

Any/all of the three components of a for loop can be left out. The following are valid for loops:

```java
// Infinite
for(;;) {
}

int i = 0;
for (;i < 5; i++){
	System.out.println(i);
}

// Multiple declarations and updates are also okay!
for (int i = 0, j = 10; i < j; i++,j--) {
	System.out.println(i);
}

```

##### while

```java
while (<condition>) {
}
```

Example:
```java
while (i < 10) {
    System.out.println(i);
}
```

A common pattern in competitive programming is for the question to have multiple test cases in a single run. In such cases, a while loop is typically useful:
```java
// no of test cases
int T = sc.nextInt();

while (T-- != 0) {      // note the post-decrement
    int n = sc.nextInt();
    // ...
}
```

##### do-while

```java
do {
    // some stuff
}
while (<condition>);    // <- note the semicolon after the end
```

##### <a name="loop-practice"></a>Practice

1.	https://www.hackerrank.com/challenges/simple-array-sum  
2.	https://www.hackerrank.com/challenges/filling-jars  
3.	https://www.hackerrank.com/challenges/mini-max-sum  

### <a name="assignments"></a>Home Assignments

1.	https://www.hackerrank.com/challenges/handshake  
2.	https://www.hackerrank.com/challenges/summing-the-n-series  
3.	https://www.hackerrank.com/challenges/staircase  
4.	https://www.hackerrank.com/challenges/kangaroo  
5.	https://www.hackerrank.com/challenges/utopian-tree  
6.	https://www.hackerrank.com/challenges/strange-grid  
7.	https://www.hackerrank.com/challenges/angry-professor  
8.	https://www.hackerrank.com/challenges/rectangular-game  
9.	https://www.hackerrank.com/challenges/summing-the-n-series  

