# Campus Course & Records Manager (CCRM)

## Project Overview
A console-based Java SE application for managing students, courses, enrollments, grades, transcripts, and file operations for an academic institute.

## How to Run
- Requires JDK 17 or above
- Compile and run `edu.ccrm.cli.Main`

## Evolution of Java (Timeline)
- 1995: Java 1.0 released
- 2004: Java 5 (Generics, Enums)
- 2014: Java 8 (Lambdas, Streams)
- 2017: Java 9+ (Modules, JShell)
- 2021: Java 17 (LTS)

## Java ME vs SE vs EE
| Feature      | Java ME         | Java SE         | Java EE         |
|--------------|-----------------|-----------------|-----------------|
| Target       | Mobile/Embedded | Desktop/Server  | Enterprise/Web  |
| APIs         | Limited         | Full Core       | SE + Web APIs   |
| Use Case     | Devices         | Apps/Tools      | Web Services    |

## JDK, JRE, JVM
- **JDK**: Java Development Kit (compiler, tools, JRE)
- **JRE**: Java Runtime Environment (JVM + libraries)
- **JVM**: Java Virtual Machine (executes bytecode)

## Install Java on Windows
1. Download JDK from Oracle/OpenJDK
2. Run installer
3. Set JAVA_HOME and PATH
4. Verify with `java -version`

## Eclipse Setup
1. Open Eclipse
2. Create new Java project
3. Add source folders and packages
4. Run `Main.java`

## Syllabus Mapping Table
| Topic                | File/Class/Method                |
|----------------------|----------------------------------|
| Encapsulation        | domain/Person, Student           |
| Inheritance          | domain/Person, Student, Instructor|
| Abstraction          | domain/Person (abstract)         |
| Polymorphism         | TranscriptService, toString()    |
| Singleton            | domain/AppConfig                 |
| Builder              | domain/CourseBuilder             |
| Exception Handling   | domain/DuplicateEnrollmentException, MaxCreditLimitExceededException |
| Streams              | service/CourseService, ImportExportService |
| Date/Time API        | domain/Person, Enrollment, BackupService |
| File I/O (NIO.2)     | io/ImportExportService, BackupService |
| Recursion            | util/RecursionUtil               |
| Comparator/Lambda    | util/CourseComparator            |
| Assertions           | See code comments                |

## Enabling Assertions
- Run with `java -ea` to enable assertions

## Acknowledgements
- All code is original. No external references used.

## Screenshots
Add images to the `screenshots/` folder as required.

## Demo Video
(Optional) Add a link to your demo video here.
