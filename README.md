# kRepo 
Project to demonstrate how to solve a task merging intervals defined as an integer array with a start and end value.
Intervals are saved in a list. Intervals merged if a subset is detected. As a result a merged list should be created.

#How to build

__Clone Project__

__Insert/Import Project into your development environment ( created in Eclipse 2019-09 )__

# Run and test class
__Run main in Scenario__

__Runt JUnit TestMerge__

# Usage
__Changable parameters for test cases__
_Additional console output_

// print start and resulting list

boolean print = true;

_Use task values_

// use task value from task

boolean taskValues = false;

__If task values to use is false, generate a list with 3 params__

// count of intervals

int intervallCount = 10;

// random generated number from 0 to intervallMaximum ( example 0 - 50 )

int intervallMaximum = 100;

// random generated number range (example 0 - 15)

int intervallRange = 15;

#Profiling

__Term Complexity__
Running through all elements for all items O(n) and reducing the size on iteration by 1. If a subset is detected, merge and remove the merged value.
Therefore O(n) + O(n-1) + ... + O(1) could be reached. In addition a for-loop is determinated if a merge of 2 intervals  appear.
A term complexity of O(n * log(n)) is resulting ( Proofed by tests).

__Memory usage__
Memory requirement will be the checked list size, because the list just gets manipulated and rewritten ( plus single scoped parameters = negligible).

__Toughness__
Values are validated for a special form ( array of int with 2 values, first should be smaller/equal than the second )

_Example_
Right: int[ 2, 4 ] descripes an intervall from 2 to 4.

Wrong: int[ 2, 3, 4 ] || int[ 2 ]=> ignored and not inserted into the merging list.

Wrong: null => ignored and not inserted into the merging list.
