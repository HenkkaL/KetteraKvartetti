#!/bin/bash

commit=$(git log | head -n 5 | tail -n 1 | sed -e 's/^[[:space:]]*//')

echo
echo "------------------------------------------"
echo "|                                        |"
echo "|           KETTERÄ  KVARTETTI           |"
echo "|                                        |"
echo "|             test deploy to             |"
echo "|  kettera-kvartetti-test.herokuapp.com  |"
echo "|                                        |"
echo "------------------------------------------"
echo

echo " 1. Clearing test database..."
echo
heroku pg:reset --remote heroku-test --confirm kettera-kvartetti-test

echo
echo " 2. Pushing latest commit $commit to heroku-test remote..."
echo

git push heroku-test master

echo
echo " 3. Running Cucumber tests..."
echo
cd Testeri
echo "    Changed working directory to $(pwd)."

gradle cleanTest test

echo
echo " DONE."
echo
