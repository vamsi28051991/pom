set projectLocation=https://github.com/vamsi28051991/pom
cd %projectLocation%
set classpath=%projectLocation%/tree/master/bin;%projectLocation%/tree/master/Lib/*
java org.testng.TestNG %projectLocation%\testng.xml
pause