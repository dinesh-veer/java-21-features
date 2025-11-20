//this is static final variable
static final int variable =500;
// We can define fields (they are instance fields)
String welcome = "Welcome to Unnamed classes";
int count = 0;

void main(){
    System.out.println("Static variable :" +variable);
    //modifying value of final variable gives compile time error
    //variable =100;
    printGreeting();
    count++;
    System.out.println("Count value: " + count);
}

// We can add helper methods (they are instance methods)
private void printGreeting() {
    System.out.println(welcome);
}

//to compile using command line use below
//javac -source 21 --enable-preview UnnamedClass_2.java
//or
//javac --release 21 --enable-preview UnnamedClass_2.java
//to run the program use below command
//java --enable-preview UnnamedClass_2