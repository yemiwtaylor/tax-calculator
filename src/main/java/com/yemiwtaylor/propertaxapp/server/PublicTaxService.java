package com.yemiwtaylor.propertaxapp.server;

import com.yemiwtaylor.propertaxapp.connector.IncomeTaxResource;
import com.yemiwtaylor.propertaxapp.connector.NationalInsuranceResource;
import com.yemiwtaylor.propertaxapp.connector.PrivatePensionContributionResource;
import com.yemiwtaylor.propertaxapp.connector.external.BreakDown;
import com.yemiwtaylor.propertaxapp.connector.external.PublicTaxResource;
import com.yemiwtaylor.propertaxapp.connector.external.SnapShotData;
import com.yemiwtaylor.propertaxapp.connector.external.YearlyBreakDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PublicTaxService implements PublicTaxResource {

  private static final BigDecimal taxFreeAllowance = new BigDecimal("12500.00");
  private final PrivatePensionContributionResource privatePensionContributionResource;
  private final IncomeTaxResource incomeTaxResource;
  private final NationalInsuranceResource nationalInsuranceResource;

  @Autowired
  public PublicTaxService(
      PrivatePensionContributionResource privatePensionContributionResource,
      IncomeTaxResource incomeTaxResource,
      NationalInsuranceResource nationalInsuranceResource) {
    this.privatePensionContributionResource = privatePensionContributionResource;
    this.incomeTaxResource = incomeTaxResource;
    this.nationalInsuranceResource = nationalInsuranceResource;
  }

  @Override
  public BreakDown calculateFinancialMetrics(SnapShotData snapShotData) {
    BigDecimal yearlyPensionContributions = privatePensionContributionResource.fetchPensionContributions(snapShotData.getYearlyGrossIncome(), snapShotData.getPensionContributionPercentage());
    BigDecimal yearlyTaxableIncome = snapShotData.getYearlyGrossIncome()
            .subtract(yearlyPensionContributions)
            .subtract(taxFreeAllowance)
            .max(new BigDecimal("0"));
    BigDecimal yearlyIncomeTaxContributions = incomeTaxResource.fetchIncomeTax(yearlyTaxableIncome);
    BigDecimal yearlyNatInsContributions = nationalInsuranceResource.fetchPensionContribution(snapShotData.getYearlyGrossIncome());

    return new BreakDown(
        new YearlyBreakDown(
            snapShotData.getYearlyGrossIncome(),
            yearlyPensionContributions,
            yearlyTaxableIncome,
            yearlyIncomeTaxContributions,
            yearlyNatInsContributions,
            null,
            null),
        null,
        null,
        null);
  }
}