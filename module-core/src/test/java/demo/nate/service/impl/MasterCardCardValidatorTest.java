package demo.nate.service.impl;

import demo.nate.BaseUnitTest;
import demo.nate.constant.CreditCardType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MasterCardCardValidatorTest extends BaseUnitTest {
    @Autowired
    private MasterCardCardValidator validator;

    @Test
    void getType() {
        assertEquals(CreditCardType.MASTERCARD, validator.getType());
    }

    @Test
    void validate() {
        String card1 = "5105105105105100";
        assertTrue(validator.validate(card1));

        String card2 = "510510515105100";
        assertFalse(validator.validate(card2));

        String card3 = "510510510a105100";
        assertFalse(validator.validate(card3));

        String card4 = "51051051051051001";
        assertFalse(validator.validate(card4));

        String card5 = "9111111111111111";
        assertFalse(validator.validate(card5));

    }
}