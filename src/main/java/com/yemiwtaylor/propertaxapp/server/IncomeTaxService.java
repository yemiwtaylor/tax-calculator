package com.yemiwtaylor.propertaxapp.server;

import com.yemiwtaylor.propertaxapp.connector.IncomeTaxResource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IncomeTaxService implements IncomeTaxResource {

  private static final BigDecimal taxFreeAllowance = new BigDecimal("12500.00");
  private static final BigDecimal basicRateUpperBound = new BigDecimal("50000.00");
  private static final BigDecimal higherRateUpperBound = new BigDecimal("150000.00");
  private static final BigDecimal basicRate = new BigDecimal("0.20");
  private static final BigDecimal higherRate = new BigDecimal("0.40");
  private static final BigDecimal additionalRate = new BigDecimal("0.45");

  @Override
  public BigDecimal fetchIncomeTax(BigDecimal yearlyTaxableIncome) {
    BigDecimal relevantIncome = yearlyTaxableIncome.add(taxFreeAllowance);
    BigDecimal basicTax = basicRateUpperBound
            .subtract(taxFreeAllowance)
            .min(relevantIncome.subtract(taxFreeAllowance).max(new BigDecimal("0")));
    BigDecimal higherTax = higherRateUpperBound
            .subtract(basicRateUpperBound)
            .min(relevantIncome.subtract(basicRateUpperBound).max(new BigDecimal("0")));
    BigDecimal additionalTax = relevantIncome.subtract(higherRateUpperBound).max(new BigDecimal("0"));
    BigDecimal basicTaxPayable = basicTax.multiply(basicRate);
    BigDecimal higherTaxPayable = higherTax.multiply(higherRate);
    BigDecimal additionalTaxPayable = additionalTax.multiply(additionalRate);
    return basicTaxPayable.add(higherTaxPayable).add(additionalTaxPayable);
  }
}
