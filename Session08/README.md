# Session 8

## Table of Contents
1. [The Collection Framework - Part I](#cfw)
    1. [The Collection Hierarchy](#hierarchy)
    2. [Lists, Queues and Sets](#list-queue-set)
    3. [Problems](#cfw-problems)
2. [Trees](#trees)
    1. [Binary Trees](#binary-trees)
    2. [Binary Search Trees](#bst)
3. [Assignments](#assignments)
    1. [HackerRank](#hackerrank)
    2. [Miscellaneous](#miscellaneous)

### <a name="cfw"></a>The Collection Framework

#### <a name="hierarchy"></a>The Collection Hierarchy

#### <a name="list-queue-set"></a>Lists, Queues and Sets

#### <a name="cfw-problems"></a>Problems

1. You are given a long list of space separated words. There may be duplicates. Print the list of unique words, each one on a newline that appear in the previous list. It is **not** necessary to print them in the same order as they appeared in the list.  
Input:
```
is it crazy how saying sentences backwards creates backwards sentences saying how crazy it is
```
Output:
```
is
it
crazy
how
saying
sentences
backwards
creates
```
2. Can you modify the above code to print the words out in alphabetical order?
3. Given two sorted lists of integers of size n and m, create a new list that contains all the integers in sorted order.  
Input:  
```
3 5
1
4
9
2
7
8
12
16
```
Output:  
```
1
2
4
7
8
9
12
16
```
4. You are given a list of n numbers in no particular order. For each number, print out the next highest number in the list. If there is no such number, print -1.  
Input:  
```
8
1 4 2 3 6 5 9 4
```
Output:  
```
4 6 6 6 9 9 -1 -1
```
Explanation:
For 1, the next highest number in the list is 4.  
For 4, 2 and 3 the next highest number in the list is 6.  
For 6 and 5 the next highest number in the list is 9.  
For 9, there is no next highest number.  
For 4, there is no next highest number.  
5. You are given a list of n chess moves. Each move is a string, and can be either:
    1. Any string, such as "c5", "Be6", "Nf3", etc.
    2. "undo".
    3. "print"  
After each print command, print all the moves made till now in a space separated manner.  
In case the move is "undo", undo the last move.
Input:  
```
7
c5
print
Be6
Nf3
print
undo
print
```
Output:
```
c5
c5 Be6 Nf3
c5 Be6
```


### <a name="trees"></a>Trees

#### <a name="binary-trees"></a>Binary Trees

Problems:
1. https://www.hackerrank.com/challenges/tree-preorder-traversal
2. https://www.hackerrank.com/challenges/tree-postorder-traversal
3. https://www.hackerrank.com/challenges/tree-inorder-traversal
4. https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
5. https://www.hackerrank.com/challenges/tree-top-view

#### <a name="bst"></a>Binary Search Trees

Problems:
1. https://www.hackerrank.com/challenges/is-binary-search-tree

### <a name="assignments"></a>Assignments

#### <a name="hackerrank"></a>HackerRank
1. https://www.hackerrank.com/challenges/java-list
2. https://www.hackerrank.com/challenges/java-stack
3. https://www.hackerrank.com/challenges/java-hashset
4. https://www.hackerrank.com/challenges/maximum-element
5. https://www.hackerrank.com/challenges/simple-text-editor
6. https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
7.
#### <a name="miscellaneous"></a>Miscellaneous
