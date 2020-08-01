package demo.nate.service.impl;

import demo.nate.constant.CreditCardType;
import demo.nate.service.AbstractCreditCardValidator;
import demo.nate.service.ICreditCardValidator;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class DiscoverCreditCardValidator extends AbstractCreditCardValidator {

    @Override
    public CreditCardType getType() {
        return CreditCardType.DISCOVER;
    }

    @Override
    protected String getCardPattern(){
        return "^([6011]{4})(\\d{12})";
    }
}
