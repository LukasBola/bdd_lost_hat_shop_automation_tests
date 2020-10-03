# Automation GUI Tests Framework for Lost Hat Shop website:
[![alt text](https://autodemo.testoneo.com/img/lost-hat-logo-1537241790.jpg)](https://autodemo.testoneo.com/en/)

[click here to visit website](https://autodemo.testoneo.com/en/)

## Technology stack:
   - Java - base programming language
   - Maven - app building and dependency management
   - Cucumber - BDD and wrapper for all tests
   - Selenide - functional tests
   - jUnit - test assertions
   - Allure - reporting
   - log4j - logging


## To install allure locally you can use [scoop](https://scoop.sh/) to make it easier.
In PowerShell:

    >> Set-ExecutionPolicy RemoteSigned -scope CurrentUser
    >> Invoke-Expression (New-Object System.Net.WebClient).DownloadString('https://get.scoop.sh')
    >> scoop install allure
Also, Scoop is capable of updating Allure distribution installations. To do so, navigate to the Scoop installation directory and execute

    >> \bin\checkver.ps1 allure -u
    
This will check for newer versions of Allure, and update the manifest file. Then execute

    >> scoop update allure
    
## Run tests suite via Terminal/cmd/PowerShell using maven: 
    
   
    >> mvn clean test
    >> mvn allure:report 

## To generate Allure html report and automatically open it in a web browser type in PowerShell::
        
    >> allure serve allure-results
      

## Selective tests run using tags:
  
    >> mvn clean test -Dcucumber.options="--tags @smoke, @account"
       
## Maintaining tests for a browser:

[![alt text](https://www.google.pl/chrome/static/images/chrome-logo.svg)](https://www.google.pl/chrome/?brand=CHBD&gclid=CjwKCAjwkPX0BRBKEiwA7THxiF_T4jOWBUUAWUh939P-GkTKZb_iz0uFNg7Yti-J7XEANTAJB50l9xoCbUwQAvD_BwE&gclsrc=aw.ds)
