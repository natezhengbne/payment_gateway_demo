package demo.nate.service.impl;

import demo.nate.constant.CreditCardType;
import demo.nate.service.ICreditCardValidator;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class VisaCreditCardValidator extends AmexCreditCardValidator {

    @Override
    public CreditCardType getType() {
        return CreditCardType.VISA;
    }

    @Override
    protected String getCardPattern(){
        return "^([4])(\\d{12}|\\d{15})";
    }
}
