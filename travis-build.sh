#!/bin/bash
set -e

export EXIT_STATUS=0

curl -O https://raw.githubusercontent.com/grails/grails-guides/a314e30c2da9779ee623dc44ad579f818b5c5929/travis/build-guide
chmod 777 build-guide

./build-guide || EXIT_STATUS=$?

exit $EXIT_STATUS