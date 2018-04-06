Partitioner
==============

What is it?
-------------
 
Static utility method that divide a list in sublists with a desired size.
Example, partitioning a list containing [1,2,3,4,5] with a size of 2 return [1,2],[3,4],[5].

How to use
-------------  
  ```
 List<List<Element>> result = Partitioner.partition(list<Element>, size);
  ```
  Note: 
Throw IllegalArgumentException if List is null or size is less or equal to zero. 
  
How to start
-------------

If you just want to mess around with the code a bit, there is no external dependencies (except Java 8).

If you have gradle, just run
  ```
gradle run
  ```
If you don't have gradle and want to use the wrapper run
  ```
./gradlew run
  ```
or
  ```
gradlew.bat run
  ```
  
Release
-------------
   
The most recent release is [Partitioner 1.0], released 2018-04-06.
   
The Maven group ID is `com.adneom.utils`, and the artifact ID is `partitioner`. Use
version `1.0`.
   
To add a dependency on Partitioner using Maven, use the following:
   
```xml
   <dependency>
     <groupId>com.adneom.utils</groupId>
     <artifactId>partitioner</artifactId>
     <version>1.0</version>
   </dependency>
   ```
   
   To add a dependency using Gradle:
   
   ```
   dependencies {
     compile 'com.adneom.utils:partitioner:1.0'
   }
   ```
