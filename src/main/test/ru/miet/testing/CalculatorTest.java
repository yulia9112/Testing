package main.test.ru.miet.testing;

import main.java.ru.miet.testing.Calc;
import main.java.ru.miet.testing.CalcPres;
import main.java.ru.miet.testing.CalculatorPresenter;
import main.java.ru.miet.testing.CalculatorView;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class CalculatorTest{
    private final CalcMock mock = new CalcMock(); // создание объекта класса тестирования
    private final CalculatorPresenter calcPres = new CalcPres(mock); // создается объек операции класса тестирования
    private final String[] errors = {"Wrong number inputed", "Input a number", "You can't divide by zero"}; // ошибочная строка

    @Test
    public void firstArgIsNullPlus() { // первая переменная равна нулю при сложении
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calcPres.onPlusClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void firstArgIsNullMinus() { // первая переменная равна нулю при вычитании
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calcPres.onMinusClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void firstArgIsNullDivide() { // первая переменная равна нулю при делении
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calcPres.onDivideClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void firstArgIsNullMultiply() {  // первая переменная равна нулю при умножении
        mock.a = null;
        mock.b = String.valueOf(Math.random());
        calcPres.onMultiplyClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void secondArgIsNullPlus() { // вторая переменная равна нулю при сложении
        mock.b = null;
        mock.a = String.valueOf(Math.random());
        calcPres.onPlusClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void secondArgIsNullMinus() { // вторая переменная равна нулю при вычитании
        mock.b = null;
        mock.a = String.valueOf(Math.random());
        calcPres.onMinusClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void secondArgIsNullDivide() { // вторая переменная равна нулю при делении
        mock.b = null;
        mock.a = String.valueOf(Math.random());
        calcPres.onDivideClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void secondArgIsNullMultiply() { // вторая переменная равна нулю при умножении
        mock.b = null;
        mock.a = String.valueOf(Math.random());
        calcPres.onMultiplyClicked();
        assertEquals(errors[1],mock.error);
    }
    @Test
    public void divideByZero() {  // деление на ноль
        mock.a = String.valueOf(Math.random());
        mock.b = String.valueOf(Math.random()*10e-8);
        calcPres.onDivideClicked();
        assertEquals(errors[2],mock.error);
    }
    @Test
    public void firstArgIsNaNPlus() { // первая - строка при сложении
        mock.a = "Random string";
        mock.b = String.valueOf(Math.random());
        calcPres.onPlusClicked();
        assertEquals(errors[0],mock.error);
    }
    @Test
    public void firstArgIsNaNMinus() { // первая - строка при вычитании
        mock.a = "Random string";
        mock.b = String.valueOf(Math.random());
        calcPres.onMinusClicked();
        assertEquals(errors[0],mock.error);
    }
    @Test
    public void firstArgIsNaNDivide() { // первая - строка при делении
        mock.a = "Random string";
        mock.b = String.valueOf(Math.random());
        calcPres.onDivideClicked();
        assertEquals(errors[0],mock.error);
    }
    @Test
    public void firstArgIsNaNMultiply() { // первая - строка при умножении
        mock.a = "Random string";
        mock.b = String.valueOf(Math.random());
        calcPres.onMultiplyClicked();
        assertEquals(errors[0],mock.error);
    }
    @Test
    public void secondArgIsNaNPlus() {  // вторая - строка при сложении
        mock.b = "Random string";
        mock.a = String.valueOf(Math.random());
        calcPres.onPlusClicked();
        assertEquals(errors[0],mock.error);
    }
    @Test
    public void secondArgIsNaNMinus() { // вторая - строка при вычитании
        mock.b = "Random string";
        mock.a = String.valueOf(Math.random());
        calcPres.onMinusClicked();
        assertEquals(errors[0],mock.error);
    }
    @Test
    public void secondArgIsNaNDivide() { // вторая - строка при делении
        mock.b = "Random string";
        mock.a = String.valueOf(Math.random());
        calcPres.onDivideClicked();
        assertEquals(errors[0],mock.error);
    }
    @Test
    public void secondArgIsNaNMultiply() { // вторая - строка при умножении
        mock.b = "Random string";
        mock.a = String.valueOf(Math.random());
        calcPres.onMultiplyClicked();
        assertEquals(errors[0],mock.error);
    }
    @RepeatedTest(100)
    public void plusTest() { // сложение рандомн чисел
        double a = Math.random();
        double b = Math.random();
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calcPres.onPlusClicked();
        assertEquals(a+b,mock.result);
    }
    @RepeatedTest(100)
    public void minusTest() {  // вычитание рандомн чисел
        double a = Math.random();
        double b = Math.random();
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calcPres.onMinusClicked();
        assertEquals(a-b,mock.result);
    }
    @RepeatedTest(100)
    public void divideTest() { // деление рандомн чисел
        double a = Math.random();
        double b = Math.random()+10e-7;
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calcPres.onDivideClicked();
        assertEquals(a/b,mock.result);
    }
    @RepeatedTest(100)
    public void multiplyTest() { // умножение рандомн чисел
        double a = Math.random();
        double b = Math.random();
        mock.a = String.valueOf(a);
        mock.b = String.valueOf(b);
        calcPres.onMultiplyClicked();
        assertEquals(a*b,mock.result);
    }
}