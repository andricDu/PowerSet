# PowerSet
An implementation of computing the power set of a given set. 

This program provides an extended version of a HashSet called PoweredHashSet. It contains the method getPowerSet which computes the power set of its elements, and returns the power set as another PoweredHashSet.

This program can take following type of files:

* ser files. Serialized java objects. In this case, HashSets.
* csv files. Set elements are delimited by commas. 
* newline delimited files. Each line is a set element.

ser and newline output files can be used as input again with the expected and correct effect. 

csv ouput files if used as input will not have the intended effect as the program does not have awarness of square bracket delimited subsets. 

## Given Parameters
Create a maven java project on github that is Junit tested.  The system should accept a set from a file and calculate its power set. Output should be written to a file

## Design Considerations
Provided three different input formats for the files as the specification was open ended in the description of the files. 

Chose to implement an iterative solution rather than recursive solution. This is due to the fact that the complexity is O(2^n) and as such, a stack overflow from a recursive solution is a real possibility. 

Extended HashSet class as it provides a general solution that can provide the ability of reading and writing serialized sets to and from file without the need to limit the typing of said sets. Did not extend TreeSet as ordering was not specified as a requirement and HashSets provide constant time operations. 

Extending an ArrayList would have also worked for a solution, but Sets enforce element uniqueness which is handy. 

Tried to show some of the newer Java features. Examples include try-with-resource and Streams.

## Developed With

* Maven 3.3.3
* Java 8

## Maven Dependency

* JUnit 4.12

##Building
Program is built with maven.

```
mvn clean package
```

##Running
You can run this program from within eclipse or command line.

```
PS C:\Users\Dusan\workspace\powerSetDemo> java -jar .\target\powerSetDemo-0.0.1-SNAPSHOT.jar
Incorrect Number of Arguments
Arg0: Mode (ser=serialized, csv=csv text file, nl=newline textfile)
Arg1: Input file
Arg2: Output file
```

##Samples
Sample input and output files are provided in the samples directory.

##Algorithm Scribbles

https://github.com/andricDu/PowerSet/blob/master/powersetnotes.pdf
