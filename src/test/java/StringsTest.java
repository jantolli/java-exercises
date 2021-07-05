import com.devel.exercises.lambda.Strings;
import org.junit.jupiter.api.Assertions;

class StringsTest {

    @org.junit.jupiter.api.Test
    void getUniqueCharsUsingLambda() {
        String stringWithRepeatedChars = "aaaalllllmmm";
        Assertions.assertEquals("alm", Strings.getUniqueCharsUsingLambda(stringWithRepeatedChars), "Values don't match");
    }

    @org.junit.jupiter.api.Test
    void getUniqueCharsUsingSet() {
        String stringWithRepeatedChars = "aaaalllllmmm";
        Assertions.assertEquals("alm", Strings.getUniqueCharsUsingSet(stringWithRepeatedChars), "Values don't match");
    }
}