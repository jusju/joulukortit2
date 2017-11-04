#!/usr/bin/bash

git add .
git commit -m "next version";
git push;
mvn package;
