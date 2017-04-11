Download the assignment and the dataset and extract them somewhere on your file system. The assignment archive contains an sbt project starter, while the dataset only contains the data you are going to use.

Note that the sbt project requires Java 8. Be sure that you have this version of the JVM installed on your environment.

First, copy the content of the dataset (the “resources” directory) into the directory “observatory/src/main/”, so that the .csv files are located under the “observatory/src/main/resources/” directory.

While the whole capstone project will be graded via a single assignment, we divided the whole project into 6 milestones (one per week). Concretely, it means that you will hack on the same code base from the beginning to the end, and that the starter project already contains some files that are going to be used by later milestones. Furthermore, our grader will always try to grade all the milestones, even if you only completed the first one, so be prepared to see errors for the uncompleted milestones (and just ignore them). In order to easily identify the tests which are relevant to a given milestone, tests names are prefixed by the number of the milestone and its name (e.g. “#2 - Raw data display”).

To grade your work, run the following sbt command (after sbt is launched and shows its prompt):



1
> submit <your-email> <your-token>
Where, <your-email> is the email associated with your Coursera’s account, and <your-token> is the token shown in the “How to submit” section on the top of this page.

The grader uses a JVM with limited memory: only 1.5 GB are available. It means that even if your code runs on your machine, it might fail on the grader. It is your job to design a program that fits in the available memory at run-time.

Our goal in this project is to give you as much freedom as possible in the solution space. Unfortunately, in order to be able to grade your work, we will ask you to implement some methods, for which we have fixed the type signature, and which may influence your solution. For instance, most of them are using Scala’s standard “Iterable” datatype, but not all concrete implementations of “Iterable” may scale to the high volume of data required by the project (the grader is not going to use a high volume of data, though). So, while you must not change the code that is provided with the project, your actual implementation should use appropriate and efficient data types in order to perform incremental and parallel computations. For this purpose, we have added several dependencies to the build: Spark, Akka Streams, Monix and fs2. You can use any of these libraries, if you want to, or just use the standard Scala library. However, note that the provided build just makes these libraries available in the classpath, but it does not configure their execution environment.

Last, note that there is a “src/test/” directory with test files for each milestone. We recommend that you write tests here to check your solutions, but do not remove the existing code.