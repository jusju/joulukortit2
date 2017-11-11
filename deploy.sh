#!/usr/bin/bash

COMMENTS = $1;

git pull;
git add .;
git commit -m COMMENTS;
git push;
mvn clean;
mvn package; 
scp target/joulukortit2.war jusju@palvelum.me:/var/lib/tomcat8/webapps/joulukortit2.war
