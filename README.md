# kRepo 
Project to demonstrate how to solve a task merging intervals defined as an integer array with a start and end value.
Intervals are saved in a list. Intervals merged if a subset is detected. As a result a merged list should be created.

#How to build
-Clone Project
-Insert/Import Project into your development environment ( created in Eclipse 2019-09 )

# Run and test class
-- Run main in Scenario
-- Runt JUnit TestMerge

# Usage
- Changable parameters for test cases
-- Additional console output
// print start and resulting list
boolean print = true;

-- Use task values
// use task value from task
boolean taskValues = false;

-- If taskvalues to us is false, generate a list with 3 params

// count of intervals
int intervallCount = 10;

// random generated number from 0 to intervallMaximum ( example 0 - 50 )
int intervallMaximum = 100;

// random generated number range (example 0 - 15)
int intervallRange = 15;

#Profiling

-Term Complexity
Running through all elements for all items O(n) and reducing the size on by 1. If a merge done remove the merged value and continue in the sequence.
Therefore O(n) + O(n-1) + ... + O(1) could be reached. In addition a for sequenz is could be reduced ( n - m ) if a merge of 2 intervals  appear.
Resulting a O(n * log(n)) is resulting ( Proofed by tests).

-Memory usage
Memory requirement will be equals of the checked list size, because list just get manipulated and rewritten ( plus single scoped parameters = negligible).

-Toughness
Values are validated in for special form ( array of int with 2 values, first should be smaller/equal than the second )
---Example---
Right: int[ 2, 4 ] descripes a intervall from 2 to 4.
Wrong: int[ 2, 3, 4 ] || int[ 2 ]=> ignored and not inserted into the merging list.
Wrong: null => ignored and not inserted into the merging list.
