package demo.nate.service;

import demo.nate.util.LuhnAlgorithmValidator;
import lombok.NonNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public abstract class AbstractCreditCardValidator implements InitializingBean, @NonNull ICreditCardValidator {
    @Autowired
    private CreditCardValidatorFactory factory;

    @Override
    public void afterPropertiesSet() throws Exception {
        factory.register(this);
    }

    @Override
    public Boolean validate(@NonNull String cardNum) {
        return Pattern.matches(getCardPattern(), cardNum) && LuhnAlgorithmValidator.check(cardNum);
    }

    protected abstract String getCardPattern();

}
