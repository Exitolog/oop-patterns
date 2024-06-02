package patterns.structural.wrappers.decorator.task.impl;

import patterns.structural.wrappers.decorator.task.Calculable;

import java.text.MessageFormat;

public class LogableCalculator implements Calculable {

     private final Calculable calculable;

    public LogableCalculator(Calculable calculable) {
        this.calculable = calculable;
    }


    @Override
    public void sum(String a, String b) {
        System.out.println(String.format("Суммирую %s и %s", a, b));
        calculable.sum(a, b);
    }

    @Override
    public void multiply(String a, String b) {
        System.out.println(String.format("Multiply %s from %s",a, b));
        calculable.multiply(a, b);
    }

    @Override
    public void divide(String a, String b) {
        System.out.println(String.format("Divide %s from %s", a, b));
        calculable.divide(a, b);
    }

    @Override
    public void subtraction(String a, String b) {
        System.out.println(String.format("Subtract %s from %s", a, b));
        calculable.subtraction(a, b);
    }

    @Override
    public String result() {
        return calculable.result();
    }

    @Override
    public void clear() {
        calculable.clear();
    }
}
