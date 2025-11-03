public class Calculator implements Operation{

    public double calculate(double a, double b, Operation op) {
        return op.operate(a, b);
    }

    @Override
    public double operate(double a, double b) {
        return 0;
    }
}
