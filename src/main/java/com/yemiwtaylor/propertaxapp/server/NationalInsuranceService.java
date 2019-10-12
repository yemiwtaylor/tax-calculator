package com.yemiwtaylor.propertaxapp.server;

import com.yemiwtaylor.propertaxapp.connector.NationalInsuranceResource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service
public class NationalInsuranceService implements NationalInsuranceResource {

  private static final BigDecimal monthlyNatInsLowLimit = new BigDecimal("719");
  private static final BigDecimal monthlyNatInsHighLimit = new BigDecimal("4167");
  private static final BigDecimal monthlyNatInsLowRate = new BigDecimal("0.12");
  private static final BigDecimal monthlyNatInsHighRate = new BigDecimal("0.02");

  @Override
  public BigDecimal fetchPensionContribution(BigDecimal yearlyGrossSalary) {
    BigDecimal monthlySalary = yearlyGrossSalary.divide(new BigDecimal("12"), RoundingMode.DOWN);
    if (monthlySalary.compareTo(monthlyNatInsLowLimit) > 0) {
      BigDecimal monthlyTaxableSalaryAtLowRate = monthlyNatInsHighLimit.subtract(monthlyNatInsLowLimit).min(monthlySalary.subtract(monthlyNatInsLowLimit));
      BigDecimal monthlyTaxableSalaryAtHighRate = new BigDecimal("0").min(monthlySalary.subtract(monthlyNatInsHighLimit));
      BigDecimal monthlyNatInsContribution = monthlyNatInsLowRate
          .multiply(monthlyTaxableSalaryAtLowRate)
          .add(monthlyNatInsHighRate.multiply(monthlyTaxableSalaryAtHighRate));
      return monthlyNatInsContribution.multiply(new BigDecimal("12"));
    }
    return BigDecimal.ZERO;
  }
}