interface Operation {
    double operate(double a, double b);

    Operation ADDITION = (a, b) -> a + b;
    Operation SUBTRACTION = (a , b) -> a - b;
    Operation DIVISON = (double a, double b) -> a / b;
    Operation MULTIPLICATION = (double a, double b) -> a * b;




}

