#!/bin/bash
java -Dserver.port=8989 -Xms1536m -Xmx1536m -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 common-1.0-SNAPSHOT.jar &
echo Start Success!
echo You can debug now ...
