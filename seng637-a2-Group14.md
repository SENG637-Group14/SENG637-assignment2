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
We used Mocking to simulate real objects, allowing us to isolate the unit under test and test the logic within "value2D" and "KeyedValues" objects. We used jMock to mock dependencies on these interfaces, since these interfaces do not have concrete implementations in our test environment.

This allowed us to simulate method calls, control return values, and isolate the behavior of DataUtilities methods without needing actual implementations. For example, when testing calculateColumnTotal(), we mocked a Values2D object to return predefined row counts and values, ensuring controlled and repeatable test scenarios.


**2.5 Input Partitions Design**

| Class  | Method | Equivalence Partitions  |
|--------|-------------|-----------------------------|
| `Range` | `getCentralValue()` | Positive range, Negative range, Range crossing zero, Same bounds, Extreme range |
|   | `getLowerBound()` | Positive range, Negative range, Extreme range |
|   | `getUpperBound()` | Positive range, Negative range, Extreme range, Positive Infinity |
|   | `contains(double value)` | Value within range, Does not contain value, Lower bound, Upper bound, Does not contain extreme value |
|   | `combine(Range range1, Range range2)` | Null ranges, One Null Range, Non-Overlapping Ranges, Overlapping Ranges, Adjacent Ranges, Identical Ranges, Extreme Ranges |
| `DataUtilities` | `calculateColumnTotal(Values2D data, int column)` | Two values, Positive values, Negative values, Mixed values, Empty data set |
|  | `calculateRowTotal(Values2D data, int row)` | Single value, Positive values, Negative values, Mixed values, Empty data set, Null data |
|  | `createNumberArray(double[] data)` | Empty array, Valid data, Null data |
|  | `createNumberArray2D(double[][] data)` | Empty array, Valid data, Null data, Single row, Single column, Null row |
|  | `getCumulativePercentages(KeyedValues data)` | Valid data, Null data |

Basis for Selection describes why each method was selected for testing. The DataUtilities methods were all selected because there were only five methods total. For the Range methods, the selection ensured all different types of ranges were tested.

**2.6 Test Logistics**
The team began testing once the following conditions were met.

- Software Under Test (SUT) was available for testing.
- Test Specification were finalized created.
- The test environment was properly set up.

**2.4 Test Environment**

JUnit Version: 4.11

JMock Version: Compatible with JUnit 4.11

IDE: Eclipse

System Under Test: JFreeChart

# 3 Test cases developed


Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above



| Class  | Method  | Test Method | Coverage |
|--------|----------------------------------------|-------------------------------------------------------------|-------------------------------------------------------------|
| `Range` | `getCentralValue()` | `centralValueShouldBeZero()` | Central value calculation for a simple range. |
|  |  | `testCentralValuePositiveRange()` | Central value for a positive range. |
|  |  | `testCentralValueNegativeRange()` | Central value for a negative range. |
|  |  | `testCentralValueSameBounds()` | Central value when the lower and upper bounds are the same. |
|  |  | `testCentralValueExtremeRange()` | Central value for an extreme range. |
| `DataUtilities` | `calculateColumnTotal(Values2D data, int column)` | `testCalculateColumnTotalForTwoValues()` | Calculate column total with valid data. |
|  |  | `testCalculateColumnTotalForPositiveValues()` | Calculate column total with positive values. |
|  |  | `testCalculateColumnTotalForNegativeValues()` | Calculate column total with negative values. |
|  |  | `testCalculateColumnTotalForMixedValues()` | Calculate column total with mixed values. |
|  |  | `testCalculateColumnTotalForEmptyDataSet()` | Calculate column total with an empty data set. |
|  |  | `testCalculateColumnTotalForSingleValue()` | Calculate column total for a single value. |
|  |  | `testCalculateColumnTotalForNullData()` | Calculate column total for null data. |
| `DataUtilities` | `calculateRowTotal(Values2D data, int row)` | `testCalculateRowTotalValidDataPositiveValues()` | Calculate row total for valid positive values. |
|  |  | `testCalculateRowTotalValidDataNegativeValues()` | Calculate row total for valid negative values. |
|  |  | `testCalculateRowTotalNullData()` | Calculate row total for null data. |
|  |  | `testCalculateRowTotalEmptyDataSet()` | Calculate row total for an empty dataset. |
|  |  | `testCalculateRowTotalMixedValues()` | Calculate row total for mixed values. |
|  |  | `testCalculateRowTotalSingleValue()` | Calculate row total for a single value. |
| `DataUtilities` | `createNumberArray2D(double[][] data)` | `testCreateNumberArray2DEmptyArray()` | Create a number array from an empty array. |
|  |  | `testCreateNumberArray2DValidData()` | Create a number array from valid data. |
|  |  | `testCreateNumberArray2DNullData()` | Create a number array from null data. |
|  |  | `testCreateNumberArray2DSingleRow()` | Create a number array from a single row. |
|  |  | `testCreateNumberArray2DSingleColumn()` | Create a number array from a single column. |
|  |  | `testCreateNumberArray2DNullRow()` | Create a number array from a null row. |
| `DataUtilities` | `getCumulativePercentages(KeyedValues data)` | `testGetCumulativePercentagesValidData()` | Calculate cumulative percentages for valid data. |



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

Certainly, I'll update the "Difficulties Encountered, Challenges Overcome, and Lessons Learned" section with the new challenge you mentioned. Here's the revised version:

### 5. Difficulties Encountered, Challenges Overcome, and Lessons Learned

We did encounter a couple of challenges during our project, which are highlighted below;

1. **Environment Setup and Version Compatibility:** Setting up the testing environment proved to be quite challenging than anticipated. We encountered issues with version compatibility between Eclipse, Java, and the required libraries (JUnit and JMock). We overcame this by dedicating a session to ensure everyone had a working environment.

2. **Time Management:** Balancing the workload and meeting the deadline required careful planning and time management. Regular progress checks and adjustments were necessary to ensure that all tasks were completed on time.

Lessons learned:

1. **Importance of Consistent Development Environments:** Ensuring all team members have compatible software versions from the start can save significant time and prevent frustration.

2. **Value of Mocking Frameworks:** While initially challenging, mocking frameworks like jMock can be powerful tools for unit testing, especially when dealing with complex dependencies. Investing time in learning these tools pays off in more robust and isolated tests.

3. **Effective Communication and Collaboration:** Regular check-ins and pair programming sessions were crucial in overcoming technical challenges and ensuring consistent progress.

4. **Thorough Understanding of Specifications:** Careful analysis and group discussion of the Javadoc specifications proved crucial for effective test-case design, especially when dealing with ambiguities or incomplete information.

These experiences have not only improved our technical skills but also enhanced our ability to work as a team in a software testing environment.


# 6 Comments/feedback on the lab itself

- The instructions and guidelines for this assignment were clear and well-structured, making it easier to understand and implement the test cases effectively.
- The lab exercise provided valuable experience in designing and executing structured test cases using black-box testing techniques.
- Using JMock to simulate dependencies was insightful and helped us understand how to test methods that rely on external objects.
