# Project Title: Fake Gold Bar Finder - Automated Testing
## Project Description:
This project is a test automation exercise designed to identify a fake gold bar from a set of nine using a balance scale. The fake gold bar is the only one that weighs less than the others. The goal is to automate the process of finding the fake bar by implementing an efficient algorithm that minimizes the number of weighings required.

The solution is built to interact with a web-based simulation, where the user places gold bars on either side of a balance scale, checks the result of each weighing, and identifies the fake gold bar by analyzing the outcomes.

## Features:
Automated Interaction with Web Interface: The project automates clicks on buttons such as "Weigh" and "Reset," and fills out the bowls' grids with gold bar numbers to simulate the weighing process.
Weighing Analysis: The program records the results of each weighing, enabling the algorithm to make informed decisions about which bars to weigh next.
Fake Bar Identification: Once the fake gold bar is identified, the program selects it and outputs the result, along with the number of weighings performed and a list of all weighings conducted.
Algorithm Optimization: The code is designed to use the minimum number of weighings necessary to identify the fake bar, demonstrating the efficiency of the approach.

## How to Run:
Setup: Ensure that all dependencies are installed. This project is compatible with Java and Selenium.
Execution: Run the script in your local environment. The script will automatically open the simulation website and begin the process of identifying the fake gold bar.
Output: Upon completion, the script will display the alert message confirming whether the fake gold bar was correctly identified, the total number of weighings, and the details of each weighing.

## Example Algorithm:
Insert numbers 0-2 in the left bowl and 3-5 in the right bowl.
Weigh the bars and analyze the result.
Depending on the outcome, narrow down the search by comparing different combinations of bars.
Repeat until the fake gold bar is found.
Record the results and display the final outcome.

## Project Structure
![Project Structure](https://github.com/user-attachments/assets/536807c0-aac3-459f-91dd-d879a81ca19a)

## Sample Output
![Sample Output](https://github.com/user-attachments/assets/f7ca2dd1-ecda-4a62-b4e1-44743e0b1d85)
