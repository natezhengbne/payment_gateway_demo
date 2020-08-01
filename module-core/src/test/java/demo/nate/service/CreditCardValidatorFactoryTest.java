package demo.nate.service;

import demo.nate.BaseUnitTest;
import demo.nate.constant.CreditCardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorFactoryTest extends BaseUnitTest {

    @Autowired
    private CreditCardValidatorFactory creditCardValidatorFactory;

    @Test
    void get() {
        ICreditCardValidator creditCardValidator = creditCardValidatorFactory.get(CreditCardType.AMEX.name());

        assertNotNull(creditCardValidator);
        assertEquals(CreditCardType.AMEX, creditCardValidator.getType());
    }
}