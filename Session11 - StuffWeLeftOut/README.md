# Session 11 - Stuff We Left Out

Placement preparation is difficult, especially in a constrained timeline. What follows in this README is a set of topics that we did not cover, only because other topics took priority.

Given the strong foundation in Java, Data Structures and Algorithms that you now possess, understanding these topics should not be too challenging.

## Table of Contents

1. [Data Structures and Algorithms](#dsa)
    1. [Heaps](#heaps)
    2. [Self Balancing Trees](#sbt)
2. [Java](#java)
    1. [Enums](#enums)
    1. [Packages](#packages)
    1. [Immutable Classes](#immutable)
    1. [Multi-Threading](#threading)
    1. [Nested Classes](#nested-class)


### <a name="dsa"></a>Data Structures And Aglorithms

#### <a name="heaps"></a>Heaps

1. [Heaps - HackerEarth Tutorial](https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial/)
2. [Binary Heaps - CMU Notes](https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html)
3. [Heap Topics - GeeksForGeeks](http://www.geeksforgeeks.org/heap-data-structure/)
4. [HeapSort - HackerEarth Tutorial](https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/tutorial/)

#### <a name="sbt"></a>Self Balancing Trees

1. [Self Balancing Tree Problems - GeeksForGeeks](http://www.geeksforgeeks.org/tag/self-balancing-bst/)
2. [Self Balancing BST Tutorial - Cal Poly Pomona](https://www.cpp.edu/~ftang/courses/CS241/notes/self%20balance%20bst.htm)

### <a name="java"></a>Java

#### <a name="enums"></a>Enums

> An enum type is a special data type that enables for a variable to be a set of predefined constants. The variable must be equal to one of the values that have been predefined for it. Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.

> Because they are constants, the names of an enum type's fields are in uppercase letters.

[Enums - Oracle Tutorial ](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

#### <a name="packages"></a>Packages

> To make types easier to find and use, to avoid naming conflicts, and to control access, programmers bundle groups of related types into packages.

> A package is a grouping of related types providing access protection and name space management. Note that types refers to classes, interfaces, enumerations, and annotation types.

[Packages - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/package/packages.html)

#### <a name="immutable"></a>Immutable Classes

An immutable class is one where an instance of that class cannot be modified in any way after construction. Immutable objects simplify multi-threaded code, since it eliminates the problem of shared read-write access.

Making an immutable class can be trickier than at first sight. The following resource lists down a few guidelines for writing an immutable class.

Look at the wrong and right examples in the [immutable](immutable) directory. One of the examples has been corrected. As an exercise, fix the other two faulty immutable classes as well.

[Immutable Classes - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html)

#### <a name="threading"></a>Multi Threading

Remember that:
1. Multi-threading is good, because it can take advantage of multi-core architectures, and utilizes the CPU to its fullest.
2. Multi-threading is tricky, because of issues like deadlocks, shared memory, synchronizing access, etc.

In Java, it is sufficient to understand:
1. How to create and start threads
2. The `Runnable` interface and the `Thread` class, and their methods.
3. The `sleep`, `start`, `run` and `join` methods.
4. The `volatile` keyword
5. The `synchronized` keyword

[Concurrency - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)

#### <a name="nested-class"></a>Nested Classes

> Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are called static nested classes. Non-static nested classes are called inner classes.

[Nested Classes - Oracle Tutorial](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
