package demo.nate.service.impl;

import demo.nate.BaseUnitTest;
import demo.nate.constant.CreditCardType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AmexCreditCardValidatorTest extends BaseUnitTest {

    @Autowired
    private AmexCreditCardValidator amexCreditCardValidator;

    @Test
    void getType() {
        assertEquals(CreditCardType.AMEX, amexCreditCardValidator.getType());
    }

    @Test
    void validate() {
        String card1 = "378282246310005";
        assertTrue(amexCreditCardValidator.validate(card1));

        String card2 = "3782822463100051";
        assertFalse(amexCreditCardValidator.validate(card2));

        String card3 = "278282246310005";
        assertFalse(amexCreditCardValidator.validate(card3));

        String card4 = "3782822a6310005";
        assertFalse(amexCreditCardValidator.validate(card4));

        String card5 = "37828224610005";
        assertFalse(amexCreditCardValidator.validate(card5));
    }
}