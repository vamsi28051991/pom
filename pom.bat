set projectLocation=C:\Program Files (x86)\Jenkins\workspace\GITPOM
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\Lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause