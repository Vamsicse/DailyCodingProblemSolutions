# Commonly asked Coding Problems

#### All my solutions are tested in LeetCode for best performance. Language Used: JAVA

---
#### Problem 1
Google Intern

Given a list of numbers, return whether any two sums to k. For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

[Solution](solution/SumPair.java)

---
#### Problem 2

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?

[Solution](solution/ProductArray.java)

---

#### Problem 3

This problem was asked by Google.

Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

[Solution](solution/BinaryTreeSerializeDeserialize.java) {Approach: Recursion, Difficulty: Hard}

---

#### Problem 4

This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

[Solution](solution/SmallestPositiveNumber.java)

---

#### Problem 7

This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3 i.e. 'aaa', 'ka', 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.

[Solution](solution/CountDigitDecodes.java) {DP - Dynamic Programming}

---


#### Problem 9

This problem was asked by Airbnb and Uber.

Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative. 

Also referred as Max loot problem.

For example, [2, 4, 6, 8] should return 12, since we pick 4 and 8. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

[Solution](solution/MaxSumNonAdjacent.java)  {DP - Dynamic Programming}

---


#### Problem 10
This problem was asked by Apple.

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

[Solution](solution/InvokeFunctionAfterTime.java)

---

#### Problem 11

This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.


[Solution](solution/PrefixSearchTrie.java) {Trie}

---

#### Problem 12

This problem was asked by Amazon.

There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

```
1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
```

What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

[Solution](solution/ClimbingStairs.java) {Recursion}

---

#### Problem 13

This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

[Solution](solution/LongestSubstringKUniqueChars.java) {HashMap}

---

#### Problem 15

This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.

[Solution](solution/RandomNumberInStream.java)

---

#### Problem 16

This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N. You should be as efficient with time and space as possible.

[Solution](solution/LastN.java) {ArrayList}

---

#### Problem 17

This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

```
dir
    subdir1
    subdir2
        file.ext
```        
        
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

```
dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
```

The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.

[Solution](solution/LongestAbsoluteFilePath.java)

---

#### Problem 18

This problem was asked by Google.

Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
Also referred as Sliding Window Maximum.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:


10 = max(10, 5, 2)

 7 = max(5, 2, 7)

 8 = max(2, 7, 8)
 
 8 = max(7, 8, 7)


Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.

[Solution](solution/SlidingWindowMaximum.java) {Sliding Window}

---

#### Problem 19

This problem was asked by Facebook, Walmart Labs.

A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

[Solution](solution/PaintHouse.java) {Approach: Dynamic Programming, Difficulty: Medium}

---

#### Problem 20

This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

[Solution](solution/FindIntersection.java)

---

#### Problem 21

This problem was asked by Illumina, Snapchat, Facebook.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required. 
Also referred as minimum number of platforms required/minimum platforms/minimum meeting rooms/minimum numbers of meeting rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

[Solution](solution/MinimumPlatforms.java)

---

#### Problem 22

This problem was asked by Microsoft. Word Break Problem.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

[Solution](solution/WordBreak.java) {DP, BFS}

---

#### Problem 23
This problem was asked by Google.

You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],

 [t, t, f, t],

[f, f, f, f],

[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

Also referred as Shortest Path Binary Maze problem.

[Solution](solution/ShortestPathBinaryMaze.java)

---

#### Problem 24

This problem was asked by Google.

Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true. unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true. You may augment the node to add parent pointers or any other property you would like. You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.

[Solution](solution/LockedBinaryTree.java)

---

#### Problem 25

This problem was asked by Facebook.

Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.
For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.

[Solution](solution/RegularExpression.java) {Approach: DP}, {Difficulty: Hard}

---

#### Problem 26

This problem was asked by Google.

Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

[Solution](solution/RemoveNthLastNode.java)

---

#### Problem 27

This problem was asked by Facebook. Balanced Parenthesis problem.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])", you should return true.

Given the string "([)]" or "((()", you should return false.

[Solution](solution/BalancedParenthesis.java)

----

#### Problem 29

This problem was asked by Walmart Labs, Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

[Solution](solution/RunLengthEncoding.java)

---

#### Problem 30

This problem was asked by Illumina

Rain Water Trapping: You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.

[Solution](solution/TrappingRainWater.java)

---

#### Problem 31

This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between "kitten" and "sitting" is three: substitute the "k" for "s", substitute the "e" for "i", and append a "g".

Given two strings, compute the edit distance between them.

[Solution](solution/EditDistance.java) (DP - Dynamic Programming Approach)

---

#### Problem 33

This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2

[Solution](solution/MedianFinder.java) {Heap}

---

#### Problem 34

This problem was asked by Quora.

Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. If there is more than one of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make). There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".

[Solution](solution/MinInsertsToMakePalindrome.java) {Approach: DP, Difficulty: Hard}

---

#### Problem 35

This problem was asked by Google.

(RGB values). Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

[Solution](solution/SortRGBValues.java)

---

#### Problem 36

This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.

[Solution](solution/SecondLargestBSTNode.java) (Recursion)

---

#### Problem 37

This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its powerset.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.

[Solution](solution/Subsets.java) (Recursion BackTrack)

---

#### Problem 40

This problem was asked by Google.

Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in $O(N)$ time and $O(1)$ space.

[Solution](solution/Once.java) {Approach: HashMap/BitwiseOperations, Difficulty: Easy/Medium}

----

#### Problem 42

This problem was asked by Google.

Find combination sum. Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If it cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.

[Solution](solution/CombinationSumPossibilitiesList.java) {Approach: Backtrack, Difficulty: Medium}

----

#### Problem 43

This problem was asked by Amazon.

Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.

[Solution](solution/StackUsingLinkedList.java) {Difficulty: Easy}

----

#### Problem 44

This problem was asked by Google. Count Inversions.

We can determine how "out of order" an array A is by finding the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.

Given an array, find number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.

[Solution](solution/CountInversions.java) {Recursion Merge Sort}

----

#### Problem 47

This problem was asked by Facebook.

Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling it once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy at 5 dollars and sell it at 10 dollars.

[Solution](solution/BuySellStock.java)

---

#### Problem 48

This problem was asked by Google.

Preorder and Inorder.

Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder:

```
[a, b, d, e, c, f, g]
```

And the following inorder:

```
[d, b, e, a, f, c, g]
```

You should return the following tree:

```
    a
   / \
  b   c
 / \ / \
d  e f  g
```

[Solution](solution/ConstructBTFromPreorderInorder.java)

----

#### Problem 49

This problem was asked by Amazon.

Given an array of numbers, find the maximum sum of contiguous subarray of the array (Max sum of contiguous sub array).

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.

[Solution](solution/MaximumSubarray.java)

---

#### Problem 52

This problem was asked by Google, WalmartLabs.

Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item. get(key): gets the value at key. If no such key exists, return null. Each operation should run in O(1) time.

[Solution1](solution/LRUCache.java) - {Using Linked List} Moderate

[Solution2](solution/LRU.java) - {Approach: Use DeQueue, Difficulty: Easy}

---

Problem 54

This problem was asked by Doordash and Dropbox.

Sudoku Validator or Solve Solver

[Solution1](solution/SudokuValidator.java) - SudokuValidator

[Solution2](solution/SudokuSolver.java) - SudokuSolver

---

#### Problem 58

This problem was asked by Amazon.

A sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.

[Solution](solution/SearchRotatedSortedArray.java) - {Approach: Binary Search}, {Difficulty: Medium}

---

#### Problem 60

This problem was asked by Facebook.

Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two halves.

[Solution](solution/PartitionSubsetSumMinDiff.java) {Approach: DP} {Difficulty: Medium}

---

#### Problem 61

This problem was asked by Google.

Implement integer exponentiation. That is, implement the power pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.

[Solution](solution/PowerN.java) {Approach: Recursion}

---

#### Problem 62

This problem was asked by Facebook.

There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner. You can only move right or down.

For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:

Right, then down
Down, then right
Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.

[Solution](solution/UniquePathsMxNMatrix.java)

---

#### Problem 63

This problem was asked by Microsoft.

Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found, by going left-to-right, or up-to-down.

For example, given the following:

````
[['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]
 ````
 
and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row.

[Solution](solution/WordSearch2DGrid.java) {Approach: DFS, Difficulty: Medium}

---

#### Problem 73

This problem was asked by Google.

Given the head of a singly linked list, reverse it in-place.

[Solution](solution/ReverseLinkedList.java)

---

#### Problem 74

This problem was asked by Apple.

Suppose you have a multiplication table that is N by N. That is, a 2D array where the value at the i-th row and j-th column is (i + 1) * (j + 1) (if 0-indexed) or i * j (if 1-indexed).

Given integers N and X, write a function that returns the number of times X appears as a value in an N by N multiplication table.

For example, given N = 6 and X = 12, you should return 4, since the multiplication table looks like this:

|     |     |     |     |     |     |
| --- | --- | --- | --- | --- | --- |
| 1   | 2   | 3   | 4   | 5   | 6   |
| 2   | 4   | 6   | 8   | 10  | 12  |
| 3   | 6   | 9   | 12  | 15  | 18  |
| 4   | 8   | 12  | 16  | 20  | 24  |
| 5   | 10  | 15  | 20  | 25  | 30  |
| 6   | 12  | 18  | 24  | 30  | 36  |

And there are 4 12's in the table.

[Solution](solution/CountOccurrences.java)

---

#### Problem 75

This problem was asked by Microsoft.

Given an array of numbers, find length of longest increasing subsequence in the array. Numbers does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
  
    Length is 6: 0, 2, 6, 9, 11, 15.

[Solution](solution/LongestIncSequence.java) {Approach: DP with Binary Search, Difficulty: Medium}

---

#### Problem 76

This problem was asked by Google.

You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically later as you go down each row. It does not matter whether each row itself is ordered lexicographically.

For example, given the following table:

```
cba
daf
ghi
```

This is not ordered because of the a in the center. We can remove the second column to make it ordered:

```
ca
df
gi
```

So your function should return 1, since we only needed to remove 1 column.

As another example, given the following table:

```
abcdef
```

Your function should return 0, since the rows are already ordered (there's only one row).

As another example, given the following table:

```
zyx
wvu
tsr
```

Your function should return 3, since we would need to remove all the columns to order it.

[Solution](solution/DeleteColumnsToMakeSorted.java)

---

#### Problem 77

This problem was asked by Walmart Labs and Snapchat.

Given a list of possibly overlapping intervals, return a new list of merged intervals.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].

[Solution](solution/MergeIntervals.java)

---

#### Problem 78

This problem was asked by Google.

Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.

[Solution](solution/MergeKSortedLinkedLists.java)

---

#### Problem 79

This problem was asked by Facebook.

Given an array of integers, write a function to determine whether the array could become non-decreasing (non decreasing) by modifying at most 1 element.

For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.

[Solution](solution/NonDecreasingArray.java)

---

#### Problem 80

This problem was asked by Google.

Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

```
    a
   / \
  b   c
 /
d
```

[Solution](solution/BinaryTreeDeepestNode.java)

---

#### Problem 83

This problem was asked by Google.

Invert a binary tree.

For example, given the following tree:

```
    a
   / \
  b   c
 / \  /
d   e f
```

should become:

```
  a
 / \
 c  b
 \  / \
  f e  d
```

[Solution](solution/InvertBinaryTree.java) {Queue/LinkedList}

---

#### Problem 86

This problem was asked by Google.

Remove Invalid Parenthesis.

Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).

For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.

[Solution](solution/MinRemoveValidParenthesis.java) 

---

#### Problem 88

This question was asked by ContextLogic.

Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.

[Solution](solution/DivideIntegers.java)

---

#### Problem 89
This problem was asked by Apple, LinkedIn.

Determine whether a tree is a valid binary search tree.

A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child must be less than or equal to the root and the key in the right child must be greater than or equal to the root.

[Solution](solution/ValidateBinarySearchTree.java) {Approach:Recursion, Difficulty: Medium}

---

#### Problem 90

This question was asked by Google.

Given an integer n and a list of integers l, write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform). Also referred as Random pick with black list.

[Solution](solution/RandomPickWithBlackList.java)

---

#### Problem 95

This problem was asked by Palantir.

Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering. If there is not greater permutation possible, return the permutation with the lowest value/ordering.

For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].

Can you perform the operation without allocating extra memory (disregarding the input memory)?

[Solution](solution/NextPermutation.java) {LeetCode: leetcode.com/problems/next-permutation}

---

#### Problem 96

This problem was asked by Microsoft.

Given a number in the form of a list of digits, return all possible permutations.

For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].

[Solution](solution/Permutations.java)

---

#### Problem 98

This problem was asked by Coursera.

Given a 2D board of characters and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example, given the following board/matrix:

```
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
````

exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.

[Solution](solution/WordSearch2DGrid.java)

---

#### Problem 99

This problem was asked by Microsoft.

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

[Solution](solution/LongestConsecutiveSequence.java) {Approach: Hashset & Sequence Build, Difficulty: Hard}

---

#### Problem 102

This problem was asked by Lyft.

Given a list of integers and a number K, return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].

[Solution](solution/SubArraySum.java)

---

#### Problem 106

This problem was asked by Pinterest.

Find minimum number of jumps to reach end.

Given an array of integers where each element represents the max number of steps that can be made forward from that element. Write a function to return minimum number of jumps to reach the end of array (starting from first element). 
If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)

First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.

[Solution](solution/MinJumpsToReachEnd.java) (DP - Dynamic Programming) and (BFS - Breadth First Search)

---

#### Problem 107

This problem was asked by Microsoft.

Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

```
  1
 / \
2   3
   / \
  4   5
  ```
  
[Solution](solution/BinaryTreeLevelOrderTraversal.java) {Difficulty: Medium}

---

#### Problem 108

This problem was asked by Google.

Given two strings A and B, return whether or not A can be shifted some number of times to get B.

For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.

[Solution](solution/RotatedStringSearch.java) {Approach: Iteration, Difficulty: Easy/Medium}

---

#### Problem 110

This problem was asked by Facebook.

Given a binary tree, return all paths from the root to leaves.

For example, given the tree

```
   1
  / \
 2   3
    / \
   4   5
```

it should return `[[1, 2], [1, 3, 4], [1, 3, 5]]`.

[Solution](solution/BinaryTreePaths.java)

---

#### Problem 111

This problem was asked by Google.

Given a word W and a string S, find all starting indices in S which are anagrams of W.

For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.

[Solution](solution/FindAnagrams.java) {Approach: Iteration, Difficulty: Medium}

---

#### Problem 113

This problem was asked by Google.

Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

Follow-up: given a mutable string representation, can you perform this operation in-place?

[Solution](solution/ReverseWordsInString.java) {Approach: Iteration, Difficulty: Easy}

---

#### Problem 114

This problem was asked by Facebook.

Given a string and a set of delimiters, reverse the words in the string while maintaining the relative order of the delimiters. For example, given "hello/world:here", return "here/world:hello"

Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"

[Solution](solution/ReverseWordsKeepDelimiters.java) {Approach: Iteration+Push+Pop, Difficulty: Easy}

---

#### Problem 117

This problem was asked by Facebook.

Given a binary tree, return the level of the tree with minimum sum.

[Solution](solution/BinaryTreeMaxLevelSum.java) {Approach: BFS, Difficulty: Medium}

---

#### Problem 118

This problem was asked by Walmart Labs, Google.

Squares of Sorted Array. Given a sorted list of integers, square the elements and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].

[Solution](solution/SquaresOfSortedArray.java) {Approach: 2 Pointer, Difficulty: Easy}

---

#### Problem 120

This problem was asked by Microsoft.

Implement the singleton pattern with a twist. First, instead of storing one instance, store two instances. And in every even call of getInstance(), return the first instance and in every odd call of getInstance(), return the second instance.

[Solution](solution/SingletonTwist.java) {Difficulty: Easy}

---

#### Problem 126

This problem was asked by Facebook.

Write a function that rotates a list by k elements. For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2]. Try solving this without creating a copy of the list. How many swap or move operations do you need?

{Same as #197}

[Solution](solution/ArrayRotate.java) {Approach: Using Reverse, Difficulty: Medium}

---

#### Problem 130

This problem was asked by Facebook.

Given an array of numbers representing the stock prices of a company in chronological order and an integer k, return the maximum profit you can make from k buys and sells. You must it before you can sell it, and you must sell it before you can buy it again.

For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.

[Solution](solution/BuySellStock.java)

---

#### Problem 131

This question was asked by Snapchat.

Given the head to a singly linked list, where each node also has a 'random' pointer that points to anywhere in the linked list, deep clone the list.

[Solution](solution/CloneLinkedListWithRandomPointer.java) {Difficulty: Medium, Approach:Recursion}

----

#### Problem 133

This problem was asked by Amazon.

Given a node in a binary tree, return the next bigger element, also known as the inorder successor.
(NOTE: I'm assuming this is a binary search tree, because otherwise, the problem makes no sense at all)

For example, the inorder successor of 22 is 30.

```
   10
  /  \
 5    30
     /  \
   22    35
```
You can assume each node has a parent pointer.

[Solution](solution/BSTIterator.java)

---

#### Problem 138

This problem was asked by Google.

Find the minimum number of coins required to make n cents.

You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.

For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.

[Solution](solution/CoinChange.java) {Approach: DP} {Difficulty: Medium}

---

#### Problem 140

This problem was asked by Facebook.

Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?

[Solution](solution/Once.java)

---

#### Problem 142

This problem was asked by Google.

You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string. Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.

[Solution](solution/ParenthesisValidationWildCard.java) {Approach: Iteration; Difficulty: Easy/Medium}

---

#### Problem 148

This problem was asked by Apple.

Gray code is a binary code where each successive value differ in only one bit, as well as when wrapping around. Gray code is common in hardware so that we don't see temporary spurious values during transitions.

Given a number of bits n, generate a possible gray code for it.

For example, for n = 2, one gray code would be [00, 01, 11, 10].

[Solution](solution/GrayCode.java) {Approach: Iteration, XOR, Shift Left; Difficulty: Medium}

---

#### Problem 153

Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.

Shortest word distance.

[Solution](solution/ShortestWordDistance.java) {Approach: Slide and track, Difficulty: Medium}

---

#### Problem 156

This problem was asked by Facebook.

Given a positive integer `n`, find the smallest number of squared integers which sum to `n`.

For example, given n = `13`, return `2` since `13 = 3^2 + 2^2 = 9 + 4`.

Given `n = 27`, return `3` since `27 = 3^2 + 3^2 + 3^2 = 9 + 9 + 9`.

[Solution](solution/PerfectSquares.java)

---

#### Problem 157

This problem was asked by Amazon.

Given a string, determine whether any permutation of it is a palindrome.

For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome. daily should return false, since there's no rearrangement that can form a palindrome.

[Solution](solution/PalindromePermutation.java) {Approach: HashSet, Difficulty: Medium}

---

#### Problem 159

This problem was asked by Google.

Given a string, return the first recurring character in it, or null if there is no recurring chracter.

For example, given the string "acbbac", return "b". Given the string "abcdef", return null.

[Solution](solution/FirstRecurringCharacter.java) {Approach: HashSet; Difficulty: Easy}

---

#### Problem 164

This problem was asked by Google.

You are given an array of length n + 1 whose elements belong to the set {1, 2, ..., n}. By the pigeonhole principle, there must be a duplicate. Find it in linear time and space.

[Solution](solution/FindDuplicate.java) {Approach: Array; Difficulty: Medium}

---

#### Problem 166

This problem was asked by Uber.

Implement a 2D iterator class. It will be initialized with an array of arrays, and should implement the following methods:

next(): returns the next element in the array of arrays. If there are no more elements, raise an exception.
has_next(): returns whether or not the iterator still has elements left.
For example, given the input [[1, 2], [3], [], [4, 5, 6]], calling next() repeatedly should output 1, 2, 3, 4, 5, 6.

Do not use flatten or otherwise clone the arrays. Some of the arrays can be empty.

[Solution](solution/NestedIterator.java)

---

#### Problem 168

This problem was asked by Facebook.

Given an N by N matrix, rotate it by 90 degrees clockwise.

For example, given the following matrix:
```
[[1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]]
```

you should return:
```
[[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]
```

Follow-up: What if you couldn't use any extra space?

[Solution](solution/RotateMatrix90Degrees.java)

---

#### Problem 170

This problem was asked by Facebook.

Word Ladder Problem. Given a start word, an end word, and a dictionary of valid words, find the shortest transformation sequence from start to end such that only one letter is changed at each step of the sequence, and each transformed word exists in the dictionary. If there is no possible transformation, return null. Each word in the dictionary have the same length as start and end and is lowercase.

For example, given `start = "dog"`, `end = "cat"`, and `dictionary = {"dot", "dop", "dat", "cat"}`, return `["dog", "dot", "dat", "cat"]`.

Given `start = "dog"`, `end = "cat"`, and `dictionary = {"dot", "tod", "dat", "dar"}`, return null as there is no possible transformation from dog to cat.

[Solution](solution/WordLadder.java)

---


#### Problem 171

This problem was asked by Amazon.

You are given a list of data entries that represent entries and exits of groups of people into a building. An entry looks like this:

{"timestamp": 1526579928, "count": 3, "type": "enter"}

This means 3 people entered the building. An exit looks like this:

{"timestamp": 1526580382, "count": 2, "type": "exit"}

This means that 2 people exited the building. timestamp is in Unix time.

Find the busiest period in the building, that is, the time with the most people in the building. Return it as a pair of (start, end) timestamps. You can assume the building always starts off and ends up empty, i.e. with 0 people inside.

[Solution](solution/BusiestEntry.java)

---

#### Problem 176

This problem was asked by Bloomberg.

Determine whether there exists a one-to-one character mapping from one string s1 to another s2. (Isomorphic Strings)

For example, given s1 = abc and s2 = bcd, return true since we can map a to b, b to c, and c to d.

Given s1 = foo and s2 = bar, return false since the o cannot map to two characters.

[Solution](solution/IsomorphicStrings.java) {Approach: HashMap/Array, Difficulty: Easy}

---

#### Problem 184

This problem was asked by Amazon.

Given n numbers, find the greatest common denominator (GCD) between them.

For example, given the numbers [42, 56, 14], return 14.

Solution=> https://www.geeksforgeeks.org/gcd-two-array-numbers/

---

#### Problem 186

This problem was asked by Microsoft.

Given an array of positive integers, divide the array into two subsets such that the sum difference between them is as small as possible.

For example, given [5, 10, 15, 20, 25], return the sets {10, 25} and {5, 15, 20}, which has a difference of 5, which is the smallest possible difference.

[Solution](solution/PartitionSubsetSumMinDiff.java) {Approach: DP} {Difficulty: Medium}

---

#### Problem 189

This problem was asked by Google.

Given an array of elements, return the length of the longest subarray where all its elements are distinct.

For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].

[Solution](solution/LongestLengthUniqueSubstring.java) {Approach: HashMap/Array} {Difficulty: Easy}

---

#### Problem 190

This problem was asked by Facebook.

Given a circular array, compute its maximum subarray sum in O(n) time.

For example, given [8, -1, 3, 4], return 15 as we choose the numbers 3, 4, and 8 where the 8 is obtained from wrapping around.

Given [-4, 5, 1, 0], return 6 as we choose the numbers 5 and 1.

[Solution](solution/MaximumSumCircularSubarray.java) {Difficulty: Medium}

---

#### Problem 192

This problem was asked by Google.

You are given an array of nonnegative integers. Let's say you start at the beginning of the array and are trying to advance to the end. You can advance at most, the number of steps that you're currently on. Determine whether you can get to the end of the array.

For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so return true.

Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.

[Solution](solution/MinJumpsToReachEnd.java) {Approach: DP, BFS} {Difficulty: Medium}

---

#### Problem 194

This problem was asked by Facebook.

Suppose you are given two lists of n points, one list p1, p2, ..., pn on the line y = 0 and the other list q1, q2, ..., qn on the line y = 1. Imagine a set of n line segments connecting each point pi to qi. Write an algorithm to determine how many pairs of the line segments intersect.

[Solution](solution/IntersectingLines.java) {Approach: DP} {Difficulty: Medium}

---

#### Problem 195

This problem was asked by Google.

Let M be an N by N matrix in which every row and every column is sorted. No two elements of M are equal.

Given i1, j1, i2, and j2, compute the number of elements of M smaller than M[i1, j1] and larger than M[i2, j2].

[Solution](solution/CountSmallerElementsInMatrix.java) {Approach: Iteration} {Difficulty: Medium}

---

#### Problem 197

This problem was asked by Amazon.

Given an array and a number k that's smaller than the length of the array, rotate the array to the right k elements in-place.

[Solution](solution/ArrayRotate.java)

---

#### Problem 201

This problem was asked by Google.

You are given an array of arrays of integers, where each array corresponds to a row in a triangle of numbers. 

For example, [[1], [2, 3], [1, 5, 1]] represents the triangle:

```
  1
 2 3
1 5 1
```

We define a path in the triangle to start at the top and go down one row at a time to an adjacent value, eventually ending with an entry on the bottom row. For example, 1 -> 2 -> 1. The weight of the path is the sum of the entries.

Write a program that returns the weight of the minimum weight path.

[Solution](solution/TriangleMinPathTopToBottom.java)

---

#### Problem 204

This problem was asked by Amazon.

Given a complete binary tree, count the number of nodes in faster than O(n) time. Recall that a complete binary tree has every level filled except the last, and the nodes in the last level are filled starting from the left.

[Solution](solution/BinaryTreeCompleteCountNodes.java) {Approach: Recursion, Difficulty: Medium}

---

#### Problem 210

This problem was asked by Apple.

A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:

If n is even, the next number in the sequence is n / 2

If n is odd, the next number in the sequence is 3n + 1 It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.

Bonus: What input n <= 1000000 gives the longest sequence?

[Solution](solution/CollatzSequence.java)

---

### Problem 233

This problem was asked by Apple.

Implement the function fib(n), which returns the nth number in the Fibonacci sequence, using only O(1) space.

[Solution](solution/Fibonacci.java)

---

#### Problem 245

This problem was asked by Yelp.

You are given an array of integers, where each element represents the maximum number of steps that can be jumped going forward from that element. Write a function to return the minimum number of jumps you must take in order to get from the start to the end of the array.

For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9], you should return 2, as the optimal solution involves jumping from 6 to 5, and then from 5 to 9.

[Solution](solution/MinJumpsToReachEnd.java)

---

#### Problem 273

This problem was asked by Apple.

A fixed point in an array is an element whose value is equal to its index. Given a sorted array of distinct elements, return a fixed point, if one exists. Otherwise, return False.

For example, given [-6, 0, 2, 40], you should return 2. Given [1, 5, 7, 8], you should return -1.

[Solution](solution/FixedPoint.java) {Approach: Binary Search, Difficulty: Medium}

---

#### Problem 282

This problem was asked by Netflix.

Given an array of integers, determine whether it contains a Pythagorean triplet. Recall that a Pythagorean triplet (a, b, c) is defined by the equation a^2 + b^2 = c^2.

[Solution](solution/PythagoreanTriplets.java) {Approach: Sort and Slide, Difficulty: Easy}

---

#### Problem 285

This problem was asked by Mailchimp.

You are given an array representing the heights of neighboring buildings on a city street, from east to west. The city assessor would like you to write an algorithm that returns how many of these buildings have a view of the setting sun, in order to properly value the street.

For example, given the array [3, 7, 8, 3, 6, 1], you should return 3, since the top floors of the buildings with heights 8, 6, and 1 all have an unobstructed vision to the west.

Can you do this using just one forward pass through the array?

[Solution](solution/BuildingsFacingSun.java) {Approach: Slide from end to start, Difficulty: Easy}

---

#### Problem 303

This problem was asked by Microsoft.

Given a clock time in hh:mm format, determine, to the nearest degree, the angle between the hour and the minute hands.

Bonus: When, during the course of a day, will the angle be zero?

[Solution](solution/AngleBetweenClockHands.java) {Approach: Formula, Difficulty: Easy}

---

#### Problem 310

This problem was asked by Pivotal.

Write an algorithm that finds the total number of set bits in all integers between 1 and N. Also referred as Counting Bits.

[Solution](solution/CountingBits.java)

---

#### Problem 327

This problem was asked by Amazon and Salesforce.

Write a program to merge two binary trees. Each node in the new tree should hold a value equal to the sum of the values of the corresponding nodes of the input trees.

If only one input tree has a node in a given position, the corresponding node in the new tree should match that input node.

[Solution](solution/BinaryTreesMerge.java) {Approach: Recursion, Difficulty: Medium}

---

### Problem 337

This problem was asked by Apple.

Given a linked list, uniformly shuffle the nodes. What if we want to prioritize space over time?

[Solution](solution/ShuffleElements.java) {Approach: Iteration; Difficulty: Medium}

---

#### Problem 338

This problem was asked by Facebook.

Given an integer n, find the next biggest integer with the same number of 1-bits on. For example, given the number 6 (0110 in binary), return 9 (1001).

[Solution](solution/NextIntegerWithSameTotalBits.java) {Approach: Bitwise Operations, Difficulty: Medium}

---

#### Problem 340

KClosestPointsToOrigin. This problem was asked by Google.

Given a set of points (x, y) on a 2D cartesian plane, find the two closest points (K Closest Points to Origin).
For example, given the points [(1, 1), (-1, -1), (3, 4), (6, 1), (-1, -6), (-4, -3)], return [(-1, -1), (1, 1)].

[Solution](solution/KClosestPointsToOrigin.java)   {Approach: Heap, Difficulty: Medium}

---

#### Problem 364

This problem was asked by Facebook.

Describe an algorithm to compute the longest increasing subsequence of an array of numbers in O(n log n) time.

[Solution](solution/LongestIncSequence.java) {Approach: DP with Binary Search, Difficulty: Medium}

---

#### Problem 366

This problem was asked by Amazon.

In a row of chairs. Make the person sit as far as possible.
0 in the array represents empty position and 1 represents occupied position.

[Solution](solution/FarthestSeatOnBench.java)

---

#### Problem 367

TopKFrequentElements. This problem was asked by Walmart Labs.

Find Top k frequent in a list.
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

[Solution](solution/TopKFrequentElements.java)   {Approach: Heap, Difficulty: Easy}

---

#### Problem 368

This problem was asked by Illumina.

Find Minimum Number of Platforms Required for a Railway/Bus Station.
Given arrival and departure times of all trains that reach a railway station, the task is to find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop.
   
   arr[]  = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}

   dep[] = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
       
Output: 3

There are at-most three trains at a time (time between 11:00 to 11:20)

[Solution](solution/MinimumPlatforms.java) {Approach: Sort and Slide, Difficulty: Easy}

---

#### Problem 369

Deep Clone a Graph (Graph Clone)

This problem was asked by Amazon, Facebook.

[Solution](solution/GraphClone.java)   {Approach: DFS/BFS, Difficulty: Medium}

---

#### Problem 370

Add Strings numerics and add binary strings.

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

[Solution](solution/AddStringsNumericBinary.java)   {Difficulty: Easy}

---

#### Problem 371

Check if given string is Palindrome (Ignore white spaces).  {LeetCode: Valid Palidrome}

[Solution](solution/Palindrome.java)   {Difficulty: Easy}

Check Palindrome. Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome. (Once character removal is allowed) {LeetCode: Valid Palidrome II}

[Solution](solution/PalindromeOneCharRemove.java)   {Difficulty: Easy}

---

#### Problem 372

Find First and Last Position of Element in Sorted Array.  {LeetCode: #34}

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

[Solution](solution/ElementFirstLastPositionSortedArray.java)   {Approach: Binary Search, Difficulty: Medium}

---

#### Problem 373

Search Insert Position.  {LeetCode: #35}

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

[Solution](solution/SearchInsertPosition.java)   {Approach: Binary Search, Difficulty: Medium}

---

#### Problem 374

Combination Sum 4.  {LeetCode: #377}

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target. (Sum combinations)

[Solution](solution/CombinationSum4.java)   {Approach: DP, Difficulty: Medium}

---

#### Problem 375

Traversals of Binary Tree. (Inorder, PreOrder, PostOrder, LevelOrder, ZigZagLevelOrder)

[solution](solution/BinaryTreeTraversals.java)

---
