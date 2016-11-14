#!/bin/bash
set -e

export EXIT_STATUS=0

curl -O https://raw.githubusercontent.com/grails/grails-guides/a2d214da3d37c72c93b7b53c8f04bb56fe04cd0f/travis/build-guide
chmod 777 build-guide

./build-guide || EXIT_STATUS=$?

exit $EXIT_STATUS