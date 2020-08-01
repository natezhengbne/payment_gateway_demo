package demo.nate.service.impl;

import demo.nate.constant.CreditCardType;
import demo.nate.service.AbstractCreditCardValidator;
import demo.nate.service.ICreditCardValidator;
import demo.nate.util.LuhnAlgorithmValidator;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class MasterCardCardValidator extends AbstractCreditCardValidator {

    @Override
    public CreditCardType getType() {
        return CreditCardType.MASTERCARD;
    }

    @Override
    protected String getCardPattern(){
        return "\\d{16}";
    }

    @Override
    public Boolean validate(@NonNull String cardNum) {
        if(!super.validate(cardNum)){
            return false;
        }

        int prefix = Integer.parseInt(cardNum.substring(0,2));

        return prefix >= 51 && prefix <= 55 && LuhnAlgorithmValidator.check(cardNum);
    }
}
