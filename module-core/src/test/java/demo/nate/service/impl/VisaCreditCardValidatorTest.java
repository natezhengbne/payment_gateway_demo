package demo.nate.service.impl;

import demo.nate.BaseUnitTest;
import demo.nate.constant.CreditCardType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class VisaCreditCardValidatorTest extends BaseUnitTest {

    @Autowired
    private VisaCreditCardValidator validator;

    @Test
    void getType() {
        assertEquals(CreditCardType.VISA, validator.getType());
    }

    @Test
    void validate() {
        String card1 = "4111111111111111";
        assertTrue(validator.validate(card1));

        String card2 = "3123456789012";
        assertFalse(validator.validate(card2));

        String card3 = "412345678901231";
        assertFalse(validator.validate(card3));

        String card4 = "412345678x012";
        assertFalse(validator.validate(card4));

        String card5 = "4111111111111";
        assertFalse(validator.validate(card5));

    }
}