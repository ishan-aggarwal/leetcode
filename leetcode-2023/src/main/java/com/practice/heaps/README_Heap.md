* Heap

**Min/ Max Heap**
Heap is a structure which returns the elements in increasing or decreasing order.

Let n be the total elements in the array, we need to build a heap of size k.
then time complexity will be O (n * log k)

**Problem Identification**
1.) Kth Largest or Smallest
2.) K Largest or Smallest
3.) K Points nearest to origin
4.) K Elements nearest to given elements

**Points to remember**
1.) For Kth smallest element, prepare max heap.
2.) For Kth largest element, prepare min heap.

Java Heap Implementation is provided by PriorityQueue

- PriorityQueue is by default min heap.
- We need to provide the order "Collections.reverseOrder()" in PriorityQueue constructor for preparing max heap. 