# PowerSet
An implementation of computing the power set of a given set. 

This program can take either a text file of comma separated values or it can take a serialized hashset written to file. Output is given in either text file or serialized object to file depending on the input mode.

## Given Parameters
Create a maven java project on github that is Junit tested.  The system should accept a set from a file and calculate its power set. Output should be written to a file

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
Arg0: Mode (s=serialized, t=text)
Arg1: Input file
Arg2: Output file
```

##Samples
Sample input and output files are provided in the samples directory.

##Algorithm Scribbles

https://github.com/andricDu/PowerSet/blob/master/powersetnotes.pdf
