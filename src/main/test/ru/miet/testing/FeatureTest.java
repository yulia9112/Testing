package main.test.ru.miet.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Лаба 4
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/test/ru/miet/testing/features",
        glue = "main.test.ru.miet.testing",
        tags = "@calculator", // фильтр запускаемых тестов по тэгам
        snippets = CucumberOptions.SnippetType.CAMELCASE // указывает в каком формате будет предлагать шаблон для нереализованных шагов
)
public class FeatureTest {
}
