set projectpath=C:\Users\Vijay\TrainerProject
echo %projectpath%
set classpath=%projectpath%\bin;%projectpath%\libs\*
echo %classpath%
java org.testng.TestNG %projectpath%\testng.xml
pause


