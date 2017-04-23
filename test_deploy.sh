#!/bin/bash

commit=$(git log | head -n 5 | tail -n 1 | sed -e 's/^[[:space:]]*//')

echo "Pushing latest commit $commit to heroku-test remote..."
echo

git push heroku-test master

echo
echo "Running Cucumber tests..."
echo

cd Testeri
echo "Changed working directory to $(pwd)."

gradle test

echo
echo "Done."
echo
