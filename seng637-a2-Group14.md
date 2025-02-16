**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#: 14     |     |
| -------------- | --- |
| **Student Names:** |     |
| Ayodele Oluwabusola |     |
| Gabriel Gabari |     |
| Remi Oyediji   |     |
| Taiwo Oyewole  |     |

# 1 Introduction
This report presents the black-box testing conducted by Group 14 members. We evaluated 10 methods—five each from the Range class and the DataUtilities class within the org.jfree.data package to validate the correctness and reliability of these methods.

Our approach applied structured testing techniques to ensure the system under test (SUT) behaved as expected based on the provided specifications. Through these tests, we confirmed that many functionalities performed as expected while also detecting failures and inconsistencies, revealing potential defects in the implementation.

In the following sections, we document our testing strategy, the test cases we developed, and the overall outcomes of our analysis.

# 2 Detailed description of unit test strategy

For our test strategy, we aimed for high coverage by testing both basic functionality and edge cases. To achieve this, we used equivalence partitioning and boundary value analysis to cover different input scenarios. All test cases were based on the API specifications in the Javadoc.

**2.1 Core Testing Principles**

Our approach was built around these key principles:

- Requirement-Based Testing: Each test case was directly derived from the Javadoc specifications of the methods. We selected 5 methods from both classes and did an exhaustive test on those methods, to cover major scenarios.
- Black-Box Techniques: We focused on testing inputs and expected outputs without looking at the internal code.
- Early Defect Detection: JUnit and jMock were used to automate testing, helping us catch defects early.
- Consistent Standards: We followed standard naming conventions and best practices when writing test methods.

**2.2 Test Types**

Our testing focused primarily on unit testing, ensuring each method worked as expected. To achieve this;  

- We wrote test code using JUnit  
- Used mock objects to handle dependencies  
- Verified each unit against the given requirements

The table below outlines the test types and their applicability in our project. By isolating individual units, we could systematically verify their behavior against the given requirements. 

| **Test Type**       | **Description**                                                    | **Applicable To**                                    |
|---------------------|-------------------------------------------------------------------|------------------------------------------------------|
| **Unit Testing**     | Tested individual methods to verify they behaved as expected.     | `org.jfree.data.Range`, `org.jfree.data.DataUtilities` |  

# 3 Test cases developed


Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
