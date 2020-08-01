package demo.nate.service.impl;

import demo.nate.BaseUnitTest;
import demo.nate.constant.CreditCardType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class DiscoverCreditCardValidatorTest extends BaseUnitTest {

    @Autowired
    private DiscoverCreditCardValidator validator;

    @Test
    void getType() {
        assertEquals(CreditCardType.DISCOVER, validator.getType());
    }

    @Test
    void validate() {
        String card1 = "6011111111111117";
        assertTrue(validator.validate(card1));

        String card2 = "6011112111111117";
        assertFalse(validator.validate(card2));

        String card3 = "60111111a1111117";
        assertFalse(validator.validate(card3));

        String card4 = "60111111111111171";
        assertFalse(validator.validate(card4));

        String card5 = "601111111111117";
        assertFalse(validator.validate(card5));

    }
}