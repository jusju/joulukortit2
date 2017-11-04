#!/usr/bin/bash

git pull;
git add .;
git commit -m "next version";
git push;
mvn clean;
mvn package scp /c/Users/jusju/git/joulukortit2/target/joulukortit2.war jusju@palvelum.me:/var/lib/tomcat8/webapps:
