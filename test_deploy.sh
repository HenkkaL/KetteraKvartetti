#!/bin/bash

commit=$(git log | head -n 5 | tail -n 1 | sed -e 's/^[[:space:]]*//')

echo "N.B. Database is not yet cleared since it's not in use."
echo "Uncomment the necessary lines from this script when Postgres-database is up and running."

# echo "Clearing test database..."
# echo
# heroku pg:reset --remote heroku-test

echo
echo "Pushing latest commit $commit to heroku-test remote..."
echo

git push heroku-test master

echo
echo "Running Cucumber tests..."
cd Testeri
echo "Changed working directory to $(pwd)."

gradle cleanTest test

echo
echo "Done."
echo
