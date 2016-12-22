set projectLocation=C:\Users\vthond001c\workspace\pom
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\Lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause