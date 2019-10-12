package com.yemiwtaylor.propertaxapp.connector.external;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tax-calculator")
public interface PublicTaxResource {

  @PutMapping
  BreakDown calculateFinancialMetrics(@RequestBody SnapShotData snapShotData);
}