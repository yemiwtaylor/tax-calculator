package com.yemiwtaylor.propertaxapp.connector;

import java.math.BigDecimal;

public interface NationalInsuranceResource {

  BigDecimal fetchPensionContribution(BigDecimal yearlyGrossIncome);
}
