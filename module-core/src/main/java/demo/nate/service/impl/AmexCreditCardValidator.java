package demo.nate.service.impl;

import demo.nate.constant.CreditCardType;
import demo.nate.service.AbstractCreditCardValidator;
import org.springframework.stereotype.Service;


@Service
public class AmexCreditCardValidator extends AbstractCreditCardValidator {

    @Override
    public CreditCardType getType() {
        return CreditCardType.AMEX;
    }

    @Override
    protected String getCardPattern(){
        return "^([34|37]{2})(\\d{13})";
    }

}
