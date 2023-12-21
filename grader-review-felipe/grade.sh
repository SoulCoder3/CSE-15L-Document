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

# Check for the file structure

if [[ ! -f "student-submission/ListExamples.java" ]]
then
    echo "-------------------------------------------"
    echo "Could not find ListExamples.java. Check your directory structure and try again."
    exit 1
fi

cp TestListExamples.java grading-area
cp student-submission/ListExamples.java grading-area
cp -r lib grading-area

cd grading-area

javac -J-Duser.language=en -cp $CPATH *.java 2> compile.out

if [[ $? -ne 0 ]]
then
    echo "-------------------------------------------"
    echo "Could not compile the student's code. Errors:"
    echo
    cat compile.out
    exit 1
fi

echo "-------------------------------------------"
echo "Compiled successfully. Running tests..."

echo "-------------------------------------------"
echo "Test results:"
echo 

java -cp $CPATH:. org.junit.runner.JUnitCore TestListExamples > test.out

if [[ $? -ne 0 ]]
then
    echo "Student's code failed:\n"
    grep "Failures: " test.out
else
    echo "Student's code passed:\n"
    grep "OK" test.out
fi
