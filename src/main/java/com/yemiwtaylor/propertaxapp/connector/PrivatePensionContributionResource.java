package com.yemiwtaylor.propertaxapp.connector;

import java.math.BigDecimal;

public interface PrivatePensionContributionResource {

  BigDecimal fetchPensionContributions(BigDecimal salary, BigDecimal percentage);
}