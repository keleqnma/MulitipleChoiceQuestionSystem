JAVA + Swing +Mysql, 简单的类MVC结构, 用了BeautyEye美化, 存档学校的作业= = 
以下是交给老师的文档

User Manual
=

@[可乐亲妈]
>This mini project adopted MVC frame, and it is based on Mysql database, it requires enviorments with **MYSQL** and **JAVA**. 

How to start it?
-

**1.Fulfill the Mysql database configurations.**


Unzip the big package, open the "RunnableGUI" folder, then open ```MCQcfg.properties```with Notepad++ or any IDE.
Replace the information in the red box with your own database information (you can create a new test database).
And then you could open the **CMD**, turn to the current directory, now you have **two Choices:**


- Type in ```java -jar lib\MultipleChoiceQuestionRun.jar``` to complie and run the runnable .jar file, and then you could see the GUI.

- ``` javac -cp lib\MultipleChoice.jar;lib\beautyeye_lnf.jar;lib\mysql-connector-java-8.0.11.jar MultipleChoiceGui.java ```to compile, then ``` java -cp .;lib\MultipleChoice.jar;lib\beautyeye_lnf.jar;lib\mysql-connector-java-8.0.11.jar MultipleChoiceGui ``` to run, which also works.
 
 -----------
It might take a few seconds to connect to the database and create tables, insert information.

How to use it?
-

>The external .jar package(BeaytyEye) requires **JDK1.6,1.7or1.8**, I wrote a checkenv to check the JDK version, if the version is not compatible, the GUI may not looks like so. 


