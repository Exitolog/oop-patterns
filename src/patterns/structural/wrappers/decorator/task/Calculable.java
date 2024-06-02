package patterns.structural.wrappers.decorator.task;

/**
 Abstraction describing the behavior of computing objects.
 */
public interface Calculable {
    void sum(String a, String  b);
    void multiply(String a, String  b);
    void divide(String a, String b);
    void subtraction(String a, String b);
    String result();
    void clear();
}
