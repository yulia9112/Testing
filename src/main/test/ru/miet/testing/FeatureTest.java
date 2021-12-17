package main.test.ru.miet.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/test/ru/miet/testing/features",
        glue = "main.test.ru.miet.testing",
        tags = "@calculator",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class FeatureTest {
}
