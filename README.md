# Commonly asked Coding Problems
All my solutions are in JAVA

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

[Solution](solution/ShortestPathBinaryMaze.java)

---

#### Problem 30

This problem was asked by Illumina

Rain Water Trapping: You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.

[Solution](solution/TrappingRainWater.java)

---

#### Problem 133

This problem was asked by Amazon.

Given a node in a binary tree, return the next bigger element, also known as the inorder successor. (NOTE: I'm assuming this is a binary search tree, because otherwise, the problem makes no sense at all)

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
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

#### Problem 282

This problem was asked by Netflix.

Given an array of integers, determine whether it contains a Pythagorean triplet. Recall that a Pythogorean triplet (a, b, c) is defined by the equation a^2 + b^2 = c^2.

[Solution](solution/PythagoreanTriplets.java)

---

#### Problem 366

This problem was asked by Amazon.

Make the person sit as far as possible.
0 in the array represents empty position.

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


