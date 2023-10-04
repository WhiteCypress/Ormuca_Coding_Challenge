# Ormuca_Coding_Challenge
### Question A 

The goal is to write a program that accepts 2 lines and determine whether they overlap or not.

To run the program, simply compile and run the .java file, and the console program should run successfully. The program should prompt the user to enter the coordinates of two lines. Once the coordinates are entered, the program will return a string answering whether they overlap or not.

### Question B 

The goal of this question is to write a software library that accepts 2 version string as input and returns whether one is greater than, equal, or less than the other.

For simplicity, the library is not packaged in a .jar file. The library class Zimu_Su_Question_B.java has one method named compareVersion(). It takes 2 string inputs, each of which being a version number. The method will compare the 2 version numbers and return either -1,1 or 0 indicating whether the first or second input has a greater version, or they are equal. To determine equality, 1.0 and 1.0.0 are considered equal, even though 1.0.0 has more digits. 

### Question C 

The goal of this question is to implement a LRU cache. 

I used a mixture of Hashmap and doubly LinkedList for maximum simplicity. Mixing them also enables great time complexity since Hashmap has an O(1) searching time and doubly LinkedList has an O(1) time complexity when adding to the end or removing from the head.
