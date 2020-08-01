package demo.nate.service;

import demo.nate.constant.CreditCardType;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CreditCardValidatorFactory {

    private static final Map<CreditCardType, ICreditCardValidator> validatorMap = new HashMap<>();

    public ICreditCardValidator get(@NonNull String creditCardType) {
        try{
            CreditCardType cardType = CreditCardType.valueOf(creditCardType.trim().toUpperCase());
            return validatorMap.get(cardType);
        }catch(Exception ex){
            log.error(ex.getMessage(), ex);
            throw new RuntimeException("Credit Card Type invalid");
        }
    }

    public void register(@NonNull ICreditCardValidator creditCardValidator){
        validatorMap.put(creditCardValidator.getType(), creditCardValidator);
    }
}
