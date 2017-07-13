# tv-programme-testing
This is a test task for one of the companies. This task includes work with web services, xml/json parsing and it's verifying

>The task was as following:
>Please, automate the following test case:
> 
> You have XML-file with tv programme for one of the channels available by GET http://www.vsetv.com/export/megogo/epg/3.xml 
> You also have JSON-file with currently running show on the same channel available by GET http://epg.megogo.net/channel/now?external_id=295
>
>Your task:
>1. Verify that show's start/stop time of the currently running show is the same as in tv programme
>2. Verify that show's genre_id of the currently running show is the same as in tv programme
>3. Verify that show's year and title of the currently running show is the same as in tv programme
>4. Make project structure expandable

# Technologies used
- Java 8
- Apache HttpComponents
- Google Gson
- TestNG

# How to install and run 
This is Java Maven-based project so you have to have JRE and Maven installed on your pc and then:

1. Clone the project
2. Execute 'mvn test' in a command line, this will launch the tests

# Note
The test is commonly failing because of the show data in XML either JSON is bad and it's missing some of the attributes that are checked by the test, so don't be afraid, just check the console output and then look into the log file at the root of the project - it contains previosly tested show's data so you can find out what went wrong.
