package com.yemiwtaylor.propertaxapp.connector.external;

import java.math.BigDecimal;

public class WeeklyBreakDown {

  private final BigDecimal grossSalary;
  private final BigDecimal pensionContrubuted;
  private final BigDecimal taxableIncome;
  private final BigDecimal taxContributed;
  private final BigDecimal nationalInsuranceContributed;
  private final BigDecimal studentLoanRepaid;
  private final BigDecimal netSalary;

  public WeeklyBreakDown(
      BigDecimal grossSalary,
      BigDecimal pensionContrubuted,
      BigDecimal taxableIncome,
      BigDecimal taxContributed,
      BigDecimal nationalInsuranceContributed,
      BigDecimal studentLoanRepaid,
      BigDecimal netSalary) {
    this.grossSalary = grossSalary;
    this.pensionContrubuted = pensionContrubuted;
    this.taxableIncome = taxableIncome;
    this.taxContributed = taxContributed;
    this.nationalInsuranceContributed = nationalInsuranceContributed;
    this.studentLoanRepaid = studentLoanRepaid;
    this.netSalary = netSalary;
  }
}
