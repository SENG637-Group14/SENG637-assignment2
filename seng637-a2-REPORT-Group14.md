**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#: 14     |     |
| -------------- | --- |
| **Student Names:** |     |
| Ayodele Oluwabusola |     |
| Gabriel Gabari |     |
| Remi Oyediji   |     |
| Taiwo Oyewole  |     |

# 1. Introduction
This report presents the black-box testing conducted by Group 14 members. We evaluated 10 methods—five each from the Range class and the DataUtilities class within the org.jfree.data package to validate the correctness and reliability of these methods.

In our approach, we applied structured testing techniques to ensure the system under test (SUT) behaved as expected based on the provided specifications. Through these tests, we confirmed that many functionalities performed as expected while also detecting failures and inconsistencies, revealing potential defects in the implementation.

In the following sections, we document our testing strategy, the test cases we developed, and the overall outcomes of the exercise.

Link to the TestSuite Developed;[TestSuite.java](https://github.com/SENG637-Group14/SENG637-assignment2/tree/main/JFreeChart/src/org/jfree/data/testsuite
) 


# 2. Detailed description of unit test strategy

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

- Equivalence Class (EC)
The EC divides the input domain into classes where inputs within each class are expected to behave similarly. This reduces redundancy in testing.
Application: For Range.contains(), we partitioned the input double value into three classes: "within the range," "below the range," and "above the range."

- Boundary Value Analysis (BVA)
BVA tests the boundaries of input domains to identify vulnerabilities at the extremes.
Application: For Range.contains(), boundary values included the lower and upper bounds of the range, as well as values just above and below the bounds.

- Mocking
We used Mocking to simulate real objects, allowing us to isolate the unit under test and test the logic within "value2D" and "KeyedValues" objects. We used jMock to mock dependencies on these interfaces, since these interfaces do not have concrete implementations in our test environment.

This allowed us to simulate method calls, control return values, and isolate the behavior of DataUtilities methods without needing actual implementations. For example, when testing calculateColumnTotal(), we mocked a Values2D object to return predefined row counts and values, ensuring controlled and repeatable test scenarios.

** Benefits and Drawbacks of Mocking**
As much as there are benefits from mocking in terms of Isolation of Units, Control Over Dependencies, Testing in the Absence of Implementations and Simplified Test Setup, there are still drawbacks to this approach, just to mention a few;

**Drawbacks of Mocking**

1. **Over-Specification**
   - Mocking can lead to tests becoming tightly coupled to the implementation, causing them to break even if the behavior remains the same. If the code changes but functionality doesn’t, mocks may need to be updated, leading to brittle tests.

2. **False Positives**
   - Incorrectly set up mocks can cause tests to pass even when the unit isn't functioning correctly, which can give a false sense of security and cause issues later.

3. **Increased Complexity**
   - Mocking could potientially add complexity to tests. Proper mock setup can be challenging and requires familiarity with mocking frameworks. This complexity can make tests harder to understand and maintain, especially if mock setups become intricate.



**2.5 Test Design Summary**

**Range Test Methods**

| Method                           | Technique Used        |
|----------------------------------|-----------------------|
| `getCentralValue()`              | Equivalence Class, Boundary Value Analysis |
| `getLowerBound()`                | Boundary Value Analysis, Equivalence Class |
| `getUpperBound()`                | Boundary Value Analysis, Equivalence Class |
| `contains(double value)`         | Equivalence Class, Boundary Value Analysis      |
| `combine(Range range1, Range range2)` | Equivalence Class, Boundary Value Analysis      |

**DataUtilities Test Methods**

| Method                                          | Technique Used    |
|-------------------------------------------------|-------------------|
| `calculateColumnTotal(Values2D data, int column)` | State Control, Equivalence Class     |
| `testCalculateColumnTotalForTwoValues()`         | State Control, Equivalence Class    |
| `testCalculateColumnTotalForPositiveValues()`    | State Control, Equivalence Class    |
| `testCalculateColumnTotalForNegativeValues()`    | State Control, Equivalence Class     |
| `testCalculateColumnTotalForMixedValues()`       | State Control, Equivalence Class    |

In Summary
We use mocking to control the state of the objects that DataUtilities depends on. This allows us to isolate DataUtilities and test it under specific, controlled conditions. While EC and BVA might not be directly applied to the inputs of DataUtilities, they still guide our selection of the data returned by the mocks to ensure we cover a range of relevant scenarios (positive values, negative values, empty datasets, etc.).

**2.6 Test Logistics**

The team began testing once the following conditions were met.

- Software Under Test (SUT) was available for testing.
- Test Specification were finalized created.
- The test environment was properly set up.

**2.7 Test Environment**

JUnit Version: 4.11

JMock Version: Compatible with JUnit 4.11

IDE: Eclipse

System Under Test: JFreeChart

# 3. Test cases developed

This section outlines the test cases designed to verify the functionality of the DataUtilities and Range classes. The tests are structured according to the source code methods they assess and are aligned with the test design summary defined in the test strategy.

**Range Test Methods**

| #  | Test Method                          | Equivalence Class        | Boundary Values                                  | Basis for Selection/Justification |
|----|--------------------------------------|-------------------------|-------------------------------------------------|----------------------------------|
| 1  | `centralValueShouldBeZero()`         | Range Crossing Zero     | -1, 1                                           | Tests the central value of a range crossing zero, with -1 and 1 as boundary values. |
| 2  | `testCentralValuePositiveRange()`    | Positive Range         | 2, 6                                           | Tests the central value of a positive range (2 to 6). |
| 3  | `testCentralValueNegativeRange()`    | Negative Range         | -6, -2                                         | Tests the central value of a negative range (-6 to -2). |
| 4  | `testCentralValueSameBounds()`       | Same Bounds            | 5, 5                                           | Tests the central value when the bounds are the same. |
| 5  | `testCentralValueExtremeRange()`     | Extreme Range          | -Double.MAX_VALUE, Double.MAX_VALUE            | Tests handling of extreme double values. |
| 6  | `lowerBoundShouldBeNegativeOne()`    | Negative Value         | -1                                             | Checks lower bound for the default range. |
| 7  | `testLowerBoundPositiveRange()`      | Positive Range         | 2                                              | Checks lower bound for a positive range (2 to 6). |
| 8  | `testLowerBoundNegativeRange()`      | Negative Range         | -6                                             | Checks lower bound for a negative range (-6 to -2). |
| 9  | `testLowerBoundExtremeRange()`       | Extreme Range          | -Double.MAX_VALUE                              | Checks lower bound with extreme values. |
| 10 | `upperBoundShouldBeOne()`            | Positive Value         | 1                                              | Checks upper bound for the default range. |
| 11 | `testUpperBoundPositiveRange()`      | Positive Range         | 6                                              | Checks upper bound for a positive range (2 to 6). |
| 12 | `testUpperBoundNegativeRange()`      | Negative Range         | -2                                             | Checks upper bound for a negative range (-6 to -2). |
| 13 | `testUpperBoundExtremeRange()`       | Extreme Range          | Double.MAX_VALUE                               | Checks upper bound with extreme values. |
| 14 | `testUpperBoundPositiveInfinity()`   | Positive Infinity      | -1000, Double.POSITIVE_INFINITY                | Tests handling of positive infinity. |
| 15 | `testRangeContainsZero()`            | Value Within Range     | -1, 0, 1                                       | Tests if 0 is within the default range (-1, 1). |
| 16 | `testRangeContainsValueWithin()`     | Value Within Range     | -5, 3, 5                                       | Checks if 3 is within the range (-5, 5). |
| 17 | `testRangeDoesNotContainValue()`     | Value Outside Range    | 1, 10, -1                                      | Tests if -1 is outside the range (1, 10). |
| 18 | `testRangeContainsLowerBound()`      | Boundary Value (Lower) | -1                                             | Checks if -1 is contained in the default range. |
| 19 | `testRangeContainsUpperBound()`      | Boundary Value (Upper) | 1                                              | Checks if 1 is contained in the default range. |
| 20 | `testRangeDoesNotContainExtremeValue()` | Value Outside Range | -1, 1, 100                                     | Tests if 100 is outside the default range. |
| 21 | `testCombineNullRanges()`            | Null Ranges           | N/A                                            | Tests combining two null ranges. |
| 22 | `testCombineOneNullRange()`          | One Null Range        | 1, 10                                          | Tests combining a valid range with a null range. |
| 23 | `testCombineNonOverlappingRanges()`  | Non-Overlapping Ranges | 1, 10, 15, 20                                  | Tests combining two non-overlapping ranges (1 to 10, 15 to 20). |
| 24 | `testCombineOverlappingRanges()`     | Overlapping Ranges    | -5, 5, 3, 10                                   | Tests combining overlapping ranges (-5 to 5, 3 to 10). |
| 25 | `testCombineAdjacentRanges()`        | Adjacent Ranges       | 5, 10, 15                                      | Tests combining adjacent ranges (5 to 10, 10 to 15). |
| 26 | `testCombineIdenticalRanges()`       | Identical Ranges      | 3, 7                                           | Tests combining two identical ranges (3 to 7). |
| 27 | `testCombineExtremeRanges()`         | Extreme Ranges        | Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, -100, 100 | Tests combining ranges with extreme values. |

**DataUtilities Test Methods**

| #  | Test Cases                                        | **Equivalence Class**      | **Boundary Values?** | **State Control** | **Justification** |
|----|--------------------------------------------------|--------------------------|---------------------|------------------|------------------|
| 1  | Calculate column total for two values           | General Numbers          | No                  | Normal           | Checks sum of two numbers. |
| 2  | Calculate column total for positive values      | Positive Numbers         | No                  | Normal           | Ensures correct summation of positive values. |
| 3  | Calculate column total for negative values      | Negative Numbers         | No                  | Normal           | Ensures summation of negative values works correctly. |
| 4  | Calculate column total for mixed values         | Mixed Numbers            | No                  | Normal           | Tests summation of both positive and negative values. |
| 5  | Calculate column total for an empty dataset     | Empty Dataset            | **Yes** (Lower)     | Normal           | Ensures empty input returns zero. |
| 6  | Calculate column total for a single value       | Single Value             | **Yes** (Lower)     | Normal           | Ensures function handles a single-element array correctly. |
| 7  | Calculate column total with null data           | **Error Handling (Null)** | **N/A**             | Exception        | Ensures `null` input throws an error. |
| 8  | Calculate row total for two values              | General Numbers          | No                  | Normal           | Tests sum of two values in a row. |
| 9  | Calculate row total with positive values        | Positive Numbers         | No                  | Normal           | Ensures summation of positive values works correctly. |
| 10 | Calculate row total with negative values        | Negative Numbers         | No                  | Normal           | Ensures summation of negative values works correctly. |
| 11 | Calculate row total with mixed values           | Mixed Numbers            | No                  | Normal           | Ensures summation of both positive and negative values. |
| 12 | Calculate row total for an empty dataset        | Empty Dataset            | **Yes** (Lower)     | Normal           | Ensures empty input returns zero. |
| 13 | Calculate row total for a single value          | Single Value             | **Yes** (Lower)     | Normal           | Ensures function handles a single-element array correctly. |
| 14 | Calculate row total with null data              | **Error Handling (Null)** | **N/A**             | Exception        | Ensures `null` input throws an error. |
| 15 | Create a 2D Number array with an empty array    | Empty Dataset            | **Yes** (Lower)     | Normal           | Ensures empty input does not crash. |
| 16 | Create a 2D Number array with valid data        | General Numbers          | No                  | Normal           | Ensures correct conversion of valid data. |
| 17 | Create a 2D Number array with null data         | **Error Handling (Null)** | **N/A**             | Exception        | Ensures `null` input throws an error. |
| 18 | Get highest in column for positive values       | Positive Numbers         | No                  | Normal           | Ensures correct maximum selection. |
| 19 | Get highest in column for mixed values          | Mixed Numbers            | No                  | Normal           | Ensures correct maximum selection. |
| 20 | Get highest in column for negative values       | Negative Numbers         | No                  | Normal           | Ensures correct maximum selection. |
| 21 | Get highest in column for an empty dataset      | Empty Dataset            | **Yes** (Lower)     | Exception        | Ensures an empty dataset returns an error or default value. |
| 22 | Get lowest in column for positive values        | Positive Numbers         | No                  | Normal           | Ensures correct minimum selection. |
| 23 | Get lowest in column for mixed values           | Mixed Numbers            | No                  | Normal           | Ensures correct minimum selection. |
| 24 | Get lowest in column for negative values        | Negative Numbers         | No                  | Normal           | Ensures correct minimum selection. |
| 25 | Get lowest in column for an empty dataset       | Empty Dataset            | **Yes** (Lower)     | Exception        | Ensures an empty dataset returns an error or default value. |
| 26 | Get highest in row for positive values          | Positive Numbers         | No                  | Normal           | Ensures correct maximum selection. |
| 27 | Get highest in row with mixed values            | Mixed Numbers            | No                  | Normal           | Ensures correct maximum selection. |
| 28 | Get lowest in row with mixed values             | Mixed Numbers            | No                  | Normal           | Ensures correct minimum selection. |


Basis for Selection describes why each method was selected for testing. The DataUtilities methods were all selected because there were only five methods total. For the Range methods, the selection ensured all different types of ranges were tested.

**Test Summary**
Number of Test cases: 55
Test Passed: 29
Test Failed: 16
Errors: 10


You can find and download an excel sheet of the test result (/Test_Results_Summary_Failed.csv) [here](https://github.com/SENG637-Group14/SENG637-assignment2/blob/main/Test_Results_Summary_Failed.csv) 


# 4. How the team work/effort was divided and managed

Every member of the team was actively involved in the entire exercise. The project was executed as follows:

| **Task**                          | **Responsibility**                                                                 |
|------------------------------------|------------------------------------------------------------------------------------|
| **Requirement Analysis**           | All team members reviewed the Javadoc API specifications for the Range and DataUtilities classes. |
| **Test-Case Design**               | Each member designed test cases for a subset of methods, applying equivalence partitioning and boundary value analysis. |
| **Test Code Implementation**      | Each member implemented the test cases they designed, using JUnit and JMock as needed. |
| **Test Execution & Result Analysis**| All team members participated in executing the test suite, analyzing results, identifying failures, and reporting potential defects. |
| **Reporting**                      | The report was collaboratively written, with each member contributing to different sections. |

**Communication & Collaboration**: Regular meetings (both in-person and virtual) and a shared online document were used to facilitate communication. This ensured that all team members were aware of progress and challenges encountered.








# 5. Difficulties encountered, challenges overcome, and lessons learned

We did encounter a couple of challenges during our project, which are highlighted below;

1. **Environment Setup and Version Compatibility:** Setting up the testing environment proved to be quite challenging than anticipated. We encountered issues with version compatibility between Eclipse, Java, and the required libraries (JUnit and JMock). We overcame this by dedicating a session to ensure everyone had a working environment.

2. **Time Management:** Balancing the workload and meeting the deadline required careful planning and time management. Regular progress checks and adjustments were necessary to ensure that all tasks were completed on time.

Lessons learned:

1. **Importance of Consistent Development Environments:** Ensuring all team members have compatible software versions from the start can save significant time and prevent frustration.

2. **Value of Mocking Frameworks:** While initially challenging, mocking frameworks like jMock can be powerful tools for unit testing, especially when dealing with complex dependencies. Investing time in learning these tools pays off in more robust and isolated tests.

3. **Effective Communication and Collaboration:** Regular check-ins and pair programming sessions were crucial in overcoming technical challenges and ensuring consistent progress.

4. **Thorough Understanding of Specifications:** Careful analysis and group discussion of the Javadoc specifications proved crucial for effective test-case design, especially when dealing with ambiguities or incomplete information.

These experiences have not only improved our technical skills but also enhanced our ability to work as a team in a software testing environment.


# 6. Comments/feedback on the lab itself

- The instructions and guidelines for this assignment were clear and well-structured, making it easier to understand and implement the test cases effectively.
- The lab exercise provided valuable experience in designing and executing structured test cases using black-box testing techniques.
- Using JMock to simulate dependencies was insightful and helped us understand how to test methods that rely on external objects.
- For DataUtilities, the methods were not straightforward, requiring a good understanding of the Javadoc to design effective test cases and the use of JMock to mock the Value2D class. This was a good exercise in interpreting API documentation. However, it was noticed that where an InvalidParameterException was expected, none was thrown. Some cases were not properly handled, resulting in a NullPointerException. Overall, it was a nice experience.
