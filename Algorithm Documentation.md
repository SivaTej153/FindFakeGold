# Algorithm Documentation for Fake Gold Bar Finder
### Overview
The algorithm is designed to efficiently identify a fake gold bar from a set of nine bars using a balance scale. The fake gold bar is the only one that weighs less than the others. The objective is to minimize the number of weighings required to find the fake bar.

### Algorithm Explanation
#### Key Concepts:
<b>Balance Scale:</b> A virtual tool that compares the weight of two groups of bars, indicating which side is heavier, or if they are equal.<br>
<b>Weighing:</b> The action of placing gold bars on the balance scale and observing the result.<br>
<b>Fake Gold Bar:</b> The bar that weighs less than the others.
### Step-by-Step Process:

1. Initial Setup:<br>
Number the gold bars from 0 to 8.<br>

2. Divide the bars into three groups:<br>
Group A: Bars 0, 1, 2<br>
Group B: Bars 3, 4, 5<br>
Group C: Bars 6, 7, 8<br>

3. First Weighing:<br>
Place Group A (bars 0, 1, 2) on the left side of the scale.<br>
Place Group B (bars 3, 4, 5) on the right side of the scale.<br>

4. Observe the Result:<br>
If the left side is heavier, the fake bar is in Group B.<br>
If the right side is heavier, the fake bar is in Group A.<br>
If both sides are equal, the fake bar is in Group C.<br>

5. Second Weighing:<br>
Depending on the result of the first weighing, focus on the identified group of three bars.<br>

6. Divide the selected group into pairs:<br>
If Group A is lighter, compare bars 0 and 1.<br>
If Group B is lighter, compare bars 3 and 4.<br>
If Group C is lighter, compare bars 6 and 7.<br>
Place the first pair on the scale.<br>

7. Observe the Result:<br>
If one side is lighter, the fake bar is on that side.<br>
If both sides are equal, the remaining unweighed bar is the fake one.<br>

8. Final Decision:<br>
Based on the second weighing, identify the exact fake bar.<br>
Click on the corresponding button to check if the identified bar is indeed the fake one.<br>

#### Example Walkthrough:

1. First Weighing:<br>
Place bars 0, 1, 2 (Group A) on the left and bars 3, 4, 5 (Group B) on the right.<br>
Result: Left side is heavier.<br>

2. Second Weighing:<br>
Now, focus on Group B (bars 3, 4, 5).<br>
Compare bars 3 and 4.<br>
Result: Both sides are equal.<br>

3. Final Decision:<br>
Since bars 3 and 4 are equal, bar 5 is the fake gold bar.<br>
Select bar 5 and confirm.<br>

<b>Efficiency of the Algorithm:</b> This algorithm ensures that the fake gold bar is found in a maximum of two weighings. By consistently reducing the problem size by two-thirds in the first weighing and by half in the second, the algorithm minimizes the number of comparisons needed, ensuring an efficient solution.<br>

#### Alternative Approaches Considered
<b>Binary Search Method:</b> Although dividing the bars into smaller groups and comparing them pair by pair could work, it would require more weighings in some cases, making it less efficient than the chosen method.
<b>Single Bar Comparison:</b> Weighing one bar at a time was dismissed due to inefficiency, as it would require up to eight weighings.

#### Conclusion
This algorithm is optimal for the given problem, balancing simplicity and efficiency to ensure the fake gold bar is found with the least effort. Its structured approach makes it easy to implement and verify through automation.

#### Pseudocode Summary
1. Divide the 9 bars into three groups of 3.
2. Weigh Group A vs Group B.
3. If Group A is heavier, the fake bar is in Group B.<br>
   If Group B is heavier, the fake bar is in Group A.<br>
   If both are equal, the fake bar is in Group C.
4. Take the lighter group and weigh two bars from it.
5. If one is lighter, it's the fake bar.
   If both are equal, the unweighed bar is the fake one.
