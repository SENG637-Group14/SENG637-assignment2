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

In our approach, we applied structured testing techniques to ensure the system under test (SUT) behaved as expected based on the provided specifications. Through these tests, we confirmed that many functionalities performed as expected while also detecting failures and inconsistencies, revealing potential defects in the implementation.

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
- We used mock objects to handle dependencies  
- Verified each unit against the given requirements

The table below outlines the test types and their applicability in our project. By isolating individual units, we could systematically verify their behavior against the given requirements. 

| **Test Type**       | **Description**                                                    | **Applicable To**                                    |
|---------------------|-------------------------------------------------------------------|------------------------------------------------------|
| **Unit Testing**     | Tested individual methods to verify they behaved as expected.     | `org.jfree.data.Range`, `org.jfree.data.DataUtilities` |  

**2.3 Test Coverage**
As required, we have created test cases for all 5 methods of DataUtilities class and chosen 5 out of 15 methods for the Range class.

- Functional Variety – Chose methods that covered different types of operations (e.g., calculations, value checks, range manipulations).  
- Edge Case Representation – Included methods where boundary value analysis could be applied.  
- Expected Test Outcomes – Ensured a mix of methods that would both pass and fail, allowing us to evaluate different testing scenarios.  
- Core vs. Less Critical Methods – Selected both commonly used and less frequently used methods to ensure balanced coverage.  

By varying the selected methods, we ensured that our test suite demonstrated both successful and failed tests, providing a more comprehensive validation of the system's behavior.

**2.4 Test Techniques**

For test techniques, we considered the following;

- Equivalence Partitioning (EP)
The EP divides the input domain into classes where inputs within each class are expected to behave similarly. This reduces redundancy in testing.
Application: For Range.contains(), we partitioned the input double value into three classes: "within the range," "below the range," and "above the range."

- Boundary Value Analysis (BVA)
BVA tests the boundaries of input domains to identify vulnerabilities at the extremes.
Application: For Range.contains(), boundary values included the lower and upper bounds of the range, as well as values just above and below the bounds.

- Mocking
We used mocking to simulate real objects, allowing us to isolate the unit under test. We used jMock to mock dependencies on interfaces like Values2D and KeyedValues.
Application: We used jMock to simulate the Values2D and KeyedValues interfaces in the DataUtilities class, allowing us to control the behavior and data returned by these dependencies, isolating the logic of the class.
###Table here - TBC

Basis for Selection describes why each method was selected for testing. The DataUtilities methods were all selected because there were only five methods total. For the Range methods, the selection ensured all different types of ranges were tested.

**2.6 Test Logistics**
The team began testing once the following conditions were met.

- Software Under Test (SUT) was available for testing.
- Test Specification were finalized created.
- The test environment was properly set up.
# 3 Test cases developed


Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Every member of the team was actively involved in the entire exercise. The project was executed as follows:

| **Task**                          | **Responsibility**                                                                 |
|------------------------------------|------------------------------------------------------------------------------------|
| **Requirement Analysis**           | All team members reviewed the Javadoc API specifications for the Range and DataUtilities classes. |
| **Test-Case Design**               | Each member designed test cases for a subset of methods, applying equivalence partitioning and boundary value analysis. |
| **Test Code Implementation**      | Each member implemented the test cases they designed, using JUnit and JMock as needed. |
| **Test Execution & Result Analysis**| All team members participated in executing the test suite, analyzing results, identifying failures, and reporting potential defects. |
| **Reporting**                      | The report was collaboratively written, with each member contributing to different sections. |

**Communication & Collaboration**: Regular meetings (both in-person and virtual) and a shared online document were used to facilitate communication. This ensured that all team members were aware of progress and challenges encountered.








# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 6 Comments/feedback on the lab itself

Text…
