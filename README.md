[Screenshot1]: https://cloud.githubusercontent.com/assets/19656425/16705691/32c9e12c-4546-11e6-9c60-28b5bd1c7793.png
[Screenshot2]: https://cloud.githubusercontent.com/assets/19656425/16705692/34ae23e0-4546-11e6-8911-f94790ff90e0.png

# Drillhole Report
A web-based reporting tool built for the [Heroku](https://www.heroku.com) cloud application platform. This java web app runs Apache Tomcat in embedded mode. It queries a PostgreSQL database and returns Drillhole records based on the user-defined date range.

## Building on the command-line with maven
To generate the start script simply run: 

```
mvn package
```

Maven will download the project's dependencies automatically when building the project.
Secondly, run the ``webapp.bat`` script found in the target/bin folder.  The application 
will start up on port 8080. You can view the JSP at ``http://localhost:8080``

## Heroku URL
https://query-drillholes.herokuapp.com

## Screenshots
![Input][Screenshot1]

![Output][Screenshot2]

## Author
Andrew Fee

