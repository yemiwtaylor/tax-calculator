package com.yemiwtaylor.propertaxapp.connector.external;

public class BreakDown {

  private final YearlyBreakDown yearlyBreakDown;
  private final MonthlyBreakDown monthlyBreakDown;
  private final WeeklyBreakDown weeklyBreakDown;
  private final DailyBreakDown dailyBreakDown;

  public BreakDown(
      YearlyBreakDown yearlyBreakDown,
      MonthlyBreakDown monthlyBreakDown,
      WeeklyBreakDown weeklyBreakDown,
      DailyBreakDown dailyBreakDown) {
    this.yearlyBreakDown = yearlyBreakDown;
    this.monthlyBreakDown = monthlyBreakDown;
    this.weeklyBreakDown = weeklyBreakDown;
    this.dailyBreakDown = dailyBreakDown;
  }

  public YearlyBreakDown getYearlyBreakDown() {
    return yearlyBreakDown;
  }

  public MonthlyBreakDown getMonthlyBreakDown() {
    return monthlyBreakDown;
  }

  public WeeklyBreakDown getWeeklyBreakDown() {
    return weeklyBreakDown;
  }

  public DailyBreakDown getDailyBreakDown() {
    return dailyBreakDown;
  }
}
