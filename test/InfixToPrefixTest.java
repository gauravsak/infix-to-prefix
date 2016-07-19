import com.company.InfixToPrefixConverter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InfixToPrefixTest {

    @Test
    public void testInfixToPrefix1() {
        assertEquals("(+ 5 4)", InfixToPrefixConverter.toPrefix("(5 + 4)"));
        assertEquals("(+ 5 4)", InfixToPrefixConverter.toPrefixRecursive("(5 + 4)"));
    }

    @Test
    public void testInfixToPrefix2() {
        assertEquals("(* 5 (+ 4 6))", InfixToPrefixConverter.toPrefix("(5 * (4 + 6))"));
        assertEquals("(* 5 (+ 4 6))", InfixToPrefixConverter.toPrefixRecursive("(5 * (4 + 6))"));
    }

    @Test
    public void testInfixToPrefix55() {
        assertEquals("(* 5 (* (- 7 2) (+ 4 6)))", InfixToPrefixConverter.toPrefix("(5 * ((7 - 2) * (4 + 6)))"));
        assertEquals("(* 5 (* (- 7 2) (+ 4 6)))", InfixToPrefixConverter.toPrefixRecursive("(5 * ((7 - 2) * (4 + 6)))"));
    }

    @Test
    public void testInfixToPrefix6() {
        assertEquals("(/ (+ 5 (+ 4 (- 2 (- 3 (+ 6 (/ 4 5)))))) (* 3 (* (- 6 2) (- 2 7))))", InfixToPrefixConverter.toPrefix("((5 + (4 + (2 - (3 - (6 + (4 / 5)))))) / (3 * ((6 - 2) * (2 - 7))))"));
        assertEquals("(/ (+ 5 (+ 4 (- 2 (- 3 (+ 6 (/ 4 5)))))) (* 3 (* (- 6 2) (- 2 7))))", InfixToPrefixConverter.toPrefixRecursive("((5 + (4 + (2 - (3 - (6 + (4 / 5)))))) / (3 * ((6 - 2) * (2 - 7))))"));
    }



}
