package com.yemiwtaylor.propertaxapp.connector;

import java.math.BigDecimal;

public interface IncomeTaxResource {

  BigDecimal fetchIncomeTax(BigDecimal yearlyTaxableIncome);
}