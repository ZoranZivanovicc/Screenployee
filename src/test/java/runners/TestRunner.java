package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Junit runner with cucumber options, use only for production tests suite
 *
 * @author  (Zoran Zivanovic)
 * @version 1.0.0
 * @since 25.01.20 updated n/a (features option updated to execute smoke test feature for production)
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "step_definitions", monochrome = true,
        dryRun = false, snippets = CucumberOptions.SnippetType.CAMELCASE,
        /*
         * tags option is commented for purpose to run all test cases in smoke test directory, if you
         * need to run individual test you can remove comment from tags option and insert annotation for
         * desired test (for example @individualTest)NOTE: the same annotation should be inserted in
         * specific feature file
         */
        tags = {"@jjjj"  },

       plugin = {"pretty", "html:report/html/"}

)

public class TestRunner {
}
