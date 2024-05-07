# 2024SS ProfCalculator

An example project to illustrate coding guidelines, version control, and design patterns.

## Setup
This project uses Maven and should be imported as Maven project in your IDE. 
The project also offers a [Maven Wrapper](https://maven.apache.org/wrapper/) that should be preferred for executing Maven. 

You can check your installation using `--version`: 

Linux / Mac 
```shell
./mvnw --version
```

Windows
```shell
mvnw.cmd --version
```

Expected Output (paths and OS may differ):
```shell
Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
Maven home: /home/alex/.m2/wrapper/dists/apache-maven-3.8.5-bin/5i5jha092a3i37g0paqnfr15e0/apache-maven-3.8.5
Java version: 22, vendor: N/A, runtime: /usr/lib/jvm/java-22-openjdk
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.6.25-1-lts", arch: "amd64", family: "unix"
``` 

## Test
You can verify that Maven is working correctly by executing the wrapper from the command line at the root of the repository.
The following command executes a clean build and runs all test cases. 
The project includes a simple test case that prints a hello world message.

Linux / Mac
```shell 
./mvnw clean test
```
Windows
```shell
mvnw.cmd clean test
```
Expected Output:
![test_execution.png](images%2Ftest_execution.png)

## App Execution
The JavaFX application can also be started with the help of Maven. 
The following command performs a clean build of the project and then executes the JavaFX application. 
The expected result is a GUI window showing a simple Calculator interface that only supports Additions.

Linux / Mac
```shell 
./mvnw clean javafx:run
```
Windows
```shell
mvnw.cmd clean javafx:run
```

Expected GUI:
![app_execution.png](images%2Fapp_execution.png)
