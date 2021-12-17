package main.test.ru.miet.testing;

import main.java.ru.miet.testing.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Лаба 3
class MainMock extends Main {
    public MainMock() {super();}
    public String error;
    @Override
    public void displayError(String message) {
        error = message;
    }
}


class UITest {
    private static MainMock app;
    private static Robot robot;
    private static double a,b;
    private final String[] errors = {"Wrong number inputed", "Input a number", "You can't divide by zero"};


    @BeforeEach
    public void init() {
        app = new MainMock();
        app.setVisible(true);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        a = Math.random();
        b = Math.random();
    }

    public void click(JButton button) throws InterruptedException { // работа с потоком в рнжиме ожидания
        Point p = button.getLocationOnScreen();
        robot.mouseMove(p.x + 20,p.y + 20); // передвижение курсора в назначенные координаты
        Thread.sleep(100); // ожидание
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(100);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(100);
    }
    private void setA(double a) throws InterruptedException {
        app.inputA.setText(Double.toString(a));
        Thread.sleep(20);
    }
    private void setB(double b) throws InterruptedException {
        app.inputB.setText(Double.toString(b));
        Thread.sleep(20);
    }

    @Test
    public void testPlus() throws InterruptedException {
        setA(a);
        setB(b);
        click(app.plus);
        assertEquals(Double.toString(a + b), app.output.getText());
        Thread.sleep(100);
    }
    @Test
    public void testMinus() throws InterruptedException {
        setA(a);
        setB(b);
        click(app.minus);
        assertEquals(Double.toString(a - b), app.output.getText());
        Thread.sleep(100);
    }
    @Test
    public void testMult() throws InterruptedException {
        setA(a);
        setB(b);
        click(app.multiply);
        assertEquals(Double.toString(a * b), app.output.getText());
        Thread.sleep(100);
    }
    @Test
    public void testDiv() throws InterruptedException {
        setA(a);
        setB(b+10e-8);
        click(app.divide);
        assertEquals(Double.toString(a / (b+10e-8)), app.output.getText());
        Thread.sleep(100);
    }
    @Test
    public void testNullPlusA() throws InterruptedException {
        app.inputA.setText(null);
        Thread.sleep(100);
        setB(b);
        click(app.plus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNullMinusA() throws InterruptedException {
        app.inputA.setText(null);
        Thread.sleep(100);
        setB(b);
        click(app.minus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNullMultA() throws InterruptedException {
        app.inputA.setText(null);
        Thread.sleep(100);
        setB(b);
        click(app.multiply);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNullDivA() throws InterruptedException {
        app.inputA.setText(null);
        Thread.sleep(100);
        setB(b);
        click(app.divide);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNullPlusB() throws InterruptedException {
        app.inputB.setText(null);
        Thread.sleep(100);
        setA(b);
        click(app.plus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNullMinusB() throws InterruptedException {
        app.inputB.setText(null);
        Thread.sleep(100);
        setA(b);
        click(app.minus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNullMultB() throws InterruptedException {
        app.inputB.setText(null);
        Thread.sleep(100);
        setA(b);
        click(app.multiply);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNullDivB() throws InterruptedException {
        app.inputB.setText(null);
        Thread.sleep(100);
        setA(b);
        click(app.divide);
        assertEquals(app.error,errors[0]);
    }

    @Test
    public void testNSPlusA() throws InterruptedException {
        app.inputA.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(app.plus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNSMinusA() throws InterruptedException {
        app.inputA.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(app.minus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNSMultA() throws InterruptedException {
        app.inputA.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(app.multiply);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNSDivA() throws InterruptedException {
        app.inputA.setText("Random");
        Thread.sleep(100);
        setB(b);
        click(app.divide);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNSPlusB() throws InterruptedException {
        app.inputB.setText("Random");
        Thread.sleep(100);
        setA(b);
        click(app.plus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNSMinusB() throws InterruptedException {
        app.inputB.setText("Random");
        Thread.sleep(100);
        setA(b);
        click(app.minus);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNSMultB() throws InterruptedException {
        app.inputB.setText("Random");
        Thread.sleep(100);
        setA(b);
        click(app.multiply);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testNSDivB() throws InterruptedException {
        app.inputB.setText("Random");
        Thread.sleep(100);
        setA(b);
        click(app.divide);
        assertEquals(app.error,errors[0]);
    }
    @Test
    public void testDivByZero() throws  InterruptedException {
        app.inputB.setText("0");
        Thread.sleep(10);
        setA(a);
        click(app.divide);
        assertEquals(app.error,errors[2]);
    }
}
