#!/bin/bash
java -Dserver.port=8989 -Xms1536m -Xmx1536m -jar common-1.0-SNAPSHOT.jar  &
echo Start Success!
