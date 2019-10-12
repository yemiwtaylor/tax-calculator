package com.yemiwtaylor.propertaxapp.server;

import com.yemiwtaylor.propertaxapp.connector.PrivatePensionContributionResource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PrivatePensionContributionService implements PrivatePensionContributionResource {

  @Override
  public BigDecimal fetchPensionContributions(BigDecimal salary, BigDecimal percentage) {
    return salary.multiply(percentage);
  }
}