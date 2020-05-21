# Session 10

## Table of Contents
1. [Exception Handling](#exceptions)
    1. [The Exception Hierarchy](#hierarchy)
    2. [Checked and Unchecked Exceptions](#checked-unchecked)
    3. [`throw` and `throws`](#throw-throws)
    4. [try-catch-finally](#tcf)
    5. [Variants of try-catch-finally](#tcf-variants)
    6. [Call Stack propagation](#propagation)
    7. [Some "Exceptional" Cases](#tcf-cases)
2. [Garbage Collection](#gc)
    1. [The Garbage Collector](#gc-core)
    2. [The `finalize` method](#finalize)
3. [Assignments](#assignments)
    1. [HackerRank](#hackerrank)
    2. [Miscellaneous](#miscellaneous)

### <a name="exceptions"></a>Exception Handling

The Java programming language uses exceptions to handle errors and other exceptional events.

An exception is an event that occurs during the execution of a program that disrupts the normal flow of instructions.

#### <a name="hierarchy"></a>The Exception Hierarchy

All exception and error implementations occur under the [`Throwable`](https://docs.oracle.com/javase/7/docs/api/java/lang/Throwable.html) class in Java.

![The Exception Hierarchy](exception_hierarchy.png)

#### <a name="checked-unchecked"></a>Checked and Unchecked Exceptions

Exceptions in Java have been partitioned into two types; checked and unchecked exceptions.
Checked exceptions are checked by the *compiler*, in that if a method throws a checked exception, then it must either handle it using a [try-catch](#tcf) block, or explicitly declare it to be thrown using the [`throws`](#throw-throws) keyword.

Unchecked exceptions are not checked by the compiler, and so the code that raises such an exception is not bound by any additional constraints.

Everything under the `RuntimeException` and `Error` classes are unchecked. Every other exception is checked.

[While the intent behind categorizing these two was good](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html), it is currently considered an overhead. There is a large set of programmers in the world, who believe that Java should have only unchecked exceptions.

In general, the guideline for deciding whether an exception you are making should be checked or unchecked is:
1. If the client using your API/library/code can recover from an exception thrown by your code, it should be checked.
    For instance, if your library allows a connection to Instagram, but limits the number of connections, and throws a "TooManyConnectionsException", the client/user can close an existing connection (in a catch block), and retry.
2. If there is no possibility of recovery, use an unchecked exception, i.e. extend from [`RuntimeException`](https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html).
    For instance, if your aforementioned library fails because the Instagram server is down, there is hardly anything that the user can do to recover from this.
    Unchecked exceptions should also be used to indicate incorrect usage of an API. For example, if the client code passes null arguments to your `authenticate` method, or something similar, you can, and should throw an [`IllegalArgumentException`](https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalArgumentException.html), which is unchecked.

#### <a name="throw-throws"></a>`throw` and `throws`

The `throw` keyword is used to, unsurprisingly, throw an exception. Continuing the example from above:

```java
class InstagramClient {
    ...

    public void authenticate(String clientKey, String clientPassword) {
        if (clientKey == null) {
            throw new IllegalArgumentException("clientKey cannot be null!");
        }

        if (clientPassword == null) {
            throw new IllegalArgumentException("clientPassword cannot be null!");
        }
        ...
    }
}
```

The `throws` keyword is used in a method declaration, to declare to the caller that this method throws a checked exception. You have already seen an example of this:

```java
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
}
```

Since [`IOException`](https://docs.oracle.com/javase/7/docs/api/java/io/IOException.html) is a checked exception, it must be declared to be thrown by the method.

If you check the documentation for the [readLine](https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html#readLine()) method of BufferedReader, you'll see that it declares that it throws IOException.

#### <a name="tcf"></a>try-catch-finally

Since we've been reading about things being thrown around, there is an obvious construct to "catch" these exceptions.

The try-catch block allows you to "try" to execute a piece of code, and if an exception is thrown, you "catch" it, and either try to recover from it, or fail gracefully.

The following is an overused, yet simple example for using try-catch

```java
class ArithmeticExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = divide(a, b);
    }

    public int divide(int a, int b) {
        int x;
        try {
            // b could be 0!
            x = a / b;
        }
        catch (ArithmeticException ae) {
            System.out.println(ae);
            return 0;   // Does not make sense to return 0, but what can you do :P
        }
        return x;
    }
}
```

The `finally` block is ALWAYS executed, regardless of whether a try is successful or not.

For example:

```java
try {
    System.out.println("In try block");
    throw new IOException("Good example for try-catch not found!");
}
catch (IOException ioe) {
    System.out.println("In catch block");
}
finally {
    System.out.println("In finally block");
}
```

will print:
```
In try block
In catch block
In finally block
```

and

```java
try {
    System.out.println("In try block");
}
catch (IOException ioe) {
    System.out.println("In catch block");
}
finally {
    System.out.println("In finally block");
}
```

will print:
```
In try block
In finally block
```

Remember that the `finally` block is **ALWAYS** executed.  
When is it executed? **ALWAYS**.

#### <a name="tcf-variants"></a>Variants of try-catch-finally

There are several possible variations of try-catch-finally, not all of which are correct. The following sections attempts to cover all of them, clearly specifying whether it is valid or invalid.

##### Valid
1. Simple try-catch
```java
try {
    // some code that throws IOException
}
catch (IOException e) {
    // some code
}
```

2. Simple try-catch-finally
```java
try {
    // some code that throws IOException
}
catch (IOException e) {
    // some code
}
finally {
    // some code
}
```

3. Nested try inside a catch (or finally) block
```java
try {
    // some code that throws IOException
}
catch (IOException e) {
    try {
        // some code    
    }
    catch (DataFormatException) {
        // some code
    }
}
```

4. Cascading catches
```java
try {
    // some code that throws IOException
}
catch (IOException ioe) {
    // some code
}
catch (ArithmeticException ae) {
    // some code
}
```

5. Try-finally with no catches
```java
try {
    // some code
}
finally {

}
```

##### Invalid

1. Just try
```java
try {
    // some code
}
```

2. Catching *checked* exceptions that cannot be thrown by the code in the try block
```java
try {
    // some code that never throws an IOException
}
catch (IOException ioe) {

}
```

3. Catching exceptions higher in the hierarchy before sub-class exceptions in a cascading catch
```java
try {
    // some code
}
catch (Exception ioe) {

}
catch (IOException ioe) {
    // This is unreachable code!
}
```

#### <a name="propagation"></a>Call Stack propagation

Q: What happens when an exception is thrown, and you don't catch it?  
A: The exception will propagate up through the call stack, till either someone catches it, or it gets thrown out of main, in which case the JVM stops the program and prints out the stack trace to the console.

It is important to remember that for a checked exception to get propagated through the call stack, *every* method on the stack will have had to have declared throwing that exception.

#### <a name="tcf-cases"></a>Some "Exceptional" Cases

1. What do you think is returned from this function? Try to execute it and find out!

```java
public static int whatThe() {
    try {
        return 10;
    }
    finally {
        return 20;
    }
}
```

2. The `finally` block **ALWAYS** executes, *unless* the JVM itself shuts down, one way of doing which is `System.exit()`. **DO NOT EVER CALL System.exit, it is a foul habit!**

### <a name="gc"></a>Garbage Collection

When objects on the heap are no longer accessible by a reference on the stack, they are cleaned up by the garbage collector.

#### <a name="gc-core"></a>The Garbage Collector

The Garbage Collector is a vast topic in itself, with varying implementations, each with its own performance and efficiency characteristics.

For now, it is sufficient to understand that the GC simply performs a DFS to look for live objects on the heap, starting from root references (on the stack), and then marks everything else as garbage collectible.

Note that we will always say that an object is "eligible" for garbage collection, and never "is being garbage collected", *because you cannot guarantee when the garbage collector runs.*

#### <a name="finalize"></a>The `finalize` method

The `finalize` method is used to perform any clean up operations, when the instance is being garbage collected.

A common misconception is that it is synonymous to a destructor in C++. **It is not.**

As usual, one of the best places to understand such core functionalities is the [JavaDoc](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#finalize()). The `finalize` method resides in the Object class, and so every class inherits the `finalize` method.

It is rare to see this method overridden by base classes.

### <a name="assignments"></a>Assignments

#### <a name="hackerrank"></a>HackerRank
1. https://www.hackerrank.com/challenges/java-exception-handling-try-catch
2. https://www.hackerrank.com/challenges/java-exception-handling

#### <a name="miscellaneous"></a>Miscellaneous
