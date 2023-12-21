CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
if [[ -f "student-submission/ListExamples.java" ]]
then
    echo "Find the testing file"
    cp student-submission/ListExamples.java ./grading-area/
    cp *.java ./grading-area/
    echo "successfully copy files"
else
    echo "Miss the testing file"
    rm -rf student-submission
fi

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar grading-area/*.java

if [[ $? == 0 ]]
then
    echo "Successfully complie the test"
else
    echo "Fail compling."
fi

java -cp .:grading-area:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > TestResult.txt

echo -e "**************\n Test Result: \n**************"
grep "Failures" TestResult.txt
grep "OK" TestResult.txt
