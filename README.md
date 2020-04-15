# Commonly asked Coding Problems

All my solutions are tested in LeetCode for best performance. They are solved in JAVA.

---
#### Problem 1
Google Intern Interview Question

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

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

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

#### Problem 20

This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

[Solution](solution/FindIntersection.java)

---

#### Problem 21

This problem was asked by Illumina and Snapchat.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required. (Also referred as minimum number of platforms required).

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

[Solution](solution/MinimumPlatforms.java)

---

#### Problem 23
This problem was asked by Google.

You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],

 [t, t, f, t],

[f, f, f, f],

[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

Also referred as Shortest Path Binary Maze problem.

[Solution](solution/ShortestPathBinaryMaze.java)

---

#### Problem 26

This problem was asked by Google.

Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

[Solution](solution/RemoveNthLastNode.java)

---

#### Problem 27

This problem was asked by Facebook.

Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])", you should return true.

Given the string "([)]" or "((()", you should return false.

[Solution](solution/BalancedParenthesis.java)

----

#### Problem 29

This problem was asked by Walmart Labs, Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

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


#### Problem 36

This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.

[Solution](solution/SecondLargestBSTNode.java) (Recursion)

---

#### Problem 40

This problem was asked by Google.

Given an array of integers where every integer occurs three times except for one integer, which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in $O(N)$ time and $O(1)$ space.

[Solution](solution/Once.java)

----

#### Problem 47

This problem was asked by Facebook.

Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.

[Solution](solution/BuySellStock.java)

---

#### Problem 52

This problem was asked by Google, WalmartLabs.

Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item. get(key): gets the value at key. If no such key exists, return null. Each operation should run in O(1) time.

[Solution1](solution/LRUCache.java) - {Using Linked List} Moderate

[Solution2](solution/LRU.java) - {Using DeQueue} Easy

---

#### Problem 61

This problem was asked by Google.

Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.

[Solution2](solution/PowerN.java) {Recursion}

---

#### Problem 73

This problem was asked by Google.

Given the head of a singly linked list, reverse it in-place.

[Solution](solution/ReverseLinkedList.java)

---

#### Problem 77

This problem was asked by Walmart Labs and Snapchat.

Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

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

Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.

[Solution](solution/NonDecreasingArray.java)

---

#### Problem 88

This question was asked by ContextLogic.

Implement division of two positive integers without using the division, multiplication, or modulus operators. Return the quotient as an integer, ignoring the remainder.

[Solution](solution/DivideIntegers.java)

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

#### Problem 133

This problem was asked by Amazon.

Given a node in a binary tree, return the next bigger element, also known as the inorder successor. (NOTE: I'm assuming this is a binary search tree, because otherwise, the problem makes no sense at all).

For example, the inorder successor of 22 is 30.

   10
   
   /   \
  
  5    30
 
   /   \

   22    35
    
You can assume each node has a parent pointer.

[Solution](solution/BinaryTreeIterator.java)

---

#### Problem 140

This problem was asked by Facebook.

Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?

[Solution](solution/Once.java)

---

#### Problem 197

This problem was asked by Amazon.

Given an array and a number k that's smaller than the length of the array, rotate the array to the right k elements in-place.

[Solution](solution/ArrayRotate.java)

---

#### Problem 210

This problem was asked by Apple.

A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:

If n is even, the next number in the sequence is n / 2

If n is odd, the next number in the sequence is 3n + 1 It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.

Bonus: What input n <= 1000000 gives the longest sequence?

[Solution](solution/CollatzSequence.java)

---

#### Problem 282

This problem was asked by Netflix.

Given an array of integers, determine whether it contains a Pythagorean triplet. Recall that a Pythogorean triplet (a, b, c) is defined by the equation a^2 + b^2 = c^2.

[Solution](solution/PythagoreanTriplets.java)

---

#### Problem 327

This problem was asked by Amazon and Salesforce.

Write a program to merge two binary trees. Each node in the new tree should hold a value equal to the sum of the values of the corresponding nodes of the input trees.

If only one input tree has a node in a given position, the corresponding node in the new tree should match that input node.

[Solution](solution/MergeBinaryTrees.java) {Recursion}

---


#### Problem 366

This problem was asked by Amazon.

In a row of chairs. Make the person sit as far as possible.
0 in the array represents empty position and 1 represents occupied position.

[Solution](solution/FarthestSeatOnBench.java)

---

#### Problem 367

This problem was asked by Walmart Labs.

Find TopKFrequentElements in a list.
Given a non-empty array of integers, return the k most frequent elements.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

[Solution](solution/TopKFrequentElements.java)

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

[Solution](solution/MinimumPlatforms.java)

---


