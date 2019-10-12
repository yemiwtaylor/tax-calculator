package com.yemiwtaylor.propertaxapp.connector.external;

import java.math.BigDecimal;

public class SnapShotData {

  private final BigDecimal yearlyGrossIncome;
  private final BigDecimal pensionContributionPercentage;

  public SnapShotData(BigDecimal yearlyGrossIncome, BigDecimal pensionContributionPercentage) {
    this.yearlyGrossIncome = yearlyGrossIncome;
    this.pensionContributionPercentage = pensionContributionPercentage;
  }

  public BigDecimal getYearlyGrossIncome() {
    return yearlyGrossIncome;
  }

  public BigDecimal getPensionContributionPercentage() {
    return pensionContributionPercentage;
  }
}