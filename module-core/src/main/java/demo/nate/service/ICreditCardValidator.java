package demo.nate.service;

import demo.nate.constant.CreditCardType;

public interface ICreditCardValidator {

    CreditCardType getType();

    Boolean validate(String cardNum);
}
