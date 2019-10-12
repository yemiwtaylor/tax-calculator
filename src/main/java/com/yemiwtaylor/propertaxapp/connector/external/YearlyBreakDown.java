package com.yemiwtaylor.propertaxapp.connector.external;

import java.math.BigDecimal;

public class YearlyBreakDown {

  private final BigDecimal grossSalary;
  private final BigDecimal pensionContrubuted;
  private final BigDecimal taxableIncome;
  private final BigDecimal taxContributed;
  private final BigDecimal nationalInsuranceContributed;
  private final BigDecimal studentLoanRepaid;
  private final BigDecimal netSalary;

  public YearlyBreakDown(
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

  public BigDecimal getGrossSalary() {
    return grossSalary;
  }

  public BigDecimal getPensionContrubuted() {
    return pensionContrubuted;
  }

  public BigDecimal getTaxableIncome() {
    return taxableIncome;
  }

  public BigDecimal getTaxContributed() {
    return taxContributed;
  }

  public BigDecimal getNationalInsuranceContributed() {
    return nationalInsuranceContributed;
  }

  public BigDecimal getStudentLoanRepaid() {
    return studentLoanRepaid;
  }

  public BigDecimal getNetSalary() {
    return netSalary;
  }
}
