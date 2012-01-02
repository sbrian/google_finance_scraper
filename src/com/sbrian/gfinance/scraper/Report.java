package com.sbrian.gfinance.scraper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanMap;

public class Report implements Comparable<Report>
{
	private CashFlow cashFlow;
	
	private IncomeStatement incomeStatement;
	
	private BalanceSheet balanceSheet;
	
	private BigDecimal stockPrice;

	private ReportSource reportSource = null;
	
	private BigDecimal annualMultiplier = null;
	
	private ReportTime reportTime;
	
	public Report(ReportTime reportTime, int annualMultiplier)
	{
		this.reportTime = reportTime;
		this.annualMultiplier = new BigDecimal(annualMultiplier + "");
	}
	
	public void setReportSource(ReportSource reportSource)
	{
		this.reportSource = reportSource;
	}
	
	public Report getPreviousReport()
	{
		return reportSource.findPreviousReport(this);
	}

	public ReportTime getReportTime()
	{
		return reportTime;
	}
	
	public CashFlow getCashFlow()
	{
		return cashFlow;
	}

	public void setCashFlow(CashFlow cashFlow)
	{
		this.cashFlow = cashFlow;
	}

	public IncomeStatement getIncomeStatement()
	{
		return incomeStatement;
	}

	public void setIncomeStatement(IncomeStatement incomeStatement)
	{
		this.incomeStatement = incomeStatement;
	}

	public BalanceSheet getBalanceSheet()
	{
		return balanceSheet;
	}

	public void setBalanceSheet(BalanceSheet balanceSheet)
	{
		this.balanceSheet = balanceSheet;
	}

	public BigDecimal getStockPrice()
	{
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice)
	{
		this.stockPrice = stockPrice;
	}
	
	public Date getEndDate()
	{
		return getReportTime().getEndDate();
	}
	
	public String getName()
	{
		return "Report for: " + getReportTime();
	}
	
	protected BigDecimal getAnnualMultiplier()
	{
		return annualMultiplier;
	}
	
	public BigDecimal getMarketCap()
	{
		if ( stockPrice == null || balanceSheet == null ) 
		{
			return null;
		}
		return BigDecimal.valueOf(balanceSheet.getTotalCommonSharesOutstanding()).multiply(getStockPrice());
	}
	
	public BigDecimal getBookValue()
	{
		if ( balanceSheet == null ) 
		{
			return null;
		}
		return balanceSheet.getTotalAssets().subtract(balanceSheet
				.getTotalLiabilities());
	}
	
	public BigDecimal getPriceToBook()
	{
		return calculatePriceToRatio(getBookValue(), false);
	}
	
	public BigDecimal getPriceToRevenue()
	{
		return calculatePriceToRatio(incomeStatement.getRevenue(), true);
	}
	
	public BigDecimal getDebtToEquity()
	{
		if ( balanceSheet == null )
		{
			return null;
		}
		return calculateRatioToPrice(balanceSheet.getTotalDebt(), false);
	}
	
	public BigDecimal getDebtToRevenue()
	{
		if ( balanceSheet == null )
		{
			return null;
		}		
		return calculateRatioToRevenue(balanceSheet.getTotalDebt(), false);
	}
	
	public BigDecimal getDebtToFreeCashFlow()
	{
		if ( balanceSheet == null )
		{
			return null;
		}
		return calculateRatioToFreeCashFlow(balanceSheet.getTotalDebt(), false);
	}
	
	public BigDecimal getAnnualizedRevenue()
	{
		return incomeStatement.getRevenue().multiply(annualMultiplier);
	}
	
	public BigDecimal getAnnualizedOperatingIncome()
	{
		return incomeStatement.getOperatingIncome().multiply(annualMultiplier);
	}
	
	public BigDecimal getAnnualizedNetIncomeBeforeExtraItems()
	{
		return incomeStatement.getNetIncomeBeforeExtraItems().multiply(annualMultiplier);
	}
	
	public BigDecimal getPriceToEarnings()
	{
		return calculatePriceToRatio(incomeStatement.getDilutedNormalizedEPS(), true);
	}
	
	public BigDecimal getAnnualizedFreeCashFlow()
	{
		if ( cashFlow.equals(BigDecimal.ZERO) ) return null;
		return getFreeCashFlow().multiply(annualMultiplier);
	}
	
	public BigDecimal getFreeCashFlow()
	{
		if ( cashFlow.equals(BigDecimal.ZERO) ) return null;
		return cashFlow.getCashFromOperatingActivities().subtract(cashFlow.getCapitalExpenditures());
	}
	
	public BigDecimal getProfitMargin()
	{
		if ( getAnnualizedRevenue() == null || 
				BigDecimal.ZERO.compareTo(getAnnualizedRevenue()) == 0 )
			return null;
		if ( getAnnualizedNetIncomeBeforeExtraItems().equals(BigDecimal.ZERO) )
			return null;
		return getAnnualizedNetIncomeBeforeExtraItems().divide(getAnnualizedRevenue(),
					2, RoundingMode.FLOOR);
	}
	
	private BigDecimal calculatePriceToRatio(BigDecimal divisor, boolean annualize)
	{
		BigDecimal marketCap = getMarketCap();
		if (marketCap == null || BigDecimal.ZERO.compareTo(divisor) == 0 )
		{
			return null;
		}
		if ( annualize )
		{
			divisor = divisor.multiply(getAnnualMultiplier());
		}
		return marketCap.divide(divisor, 2, RoundingMode.FLOOR);
	}
	
	private BigDecimal calculateRatioToPrice(BigDecimal dividend, boolean annualize)
	{
		if (stockPrice == null)
		{
			return null;
		}
		if ( annualize )
		{
			dividend = dividend.multiply(getAnnualMultiplier());
		}
		return dividend.divide(getMarketCap(), 2, RoundingMode.FLOOR);
	}
	
	private BigDecimal calculateRatioToRevenue(BigDecimal dividend, boolean annualize)
	{
		if (stockPrice == null)
		{
			return null;
		}
		BigDecimal annualizedRevenue = getAnnualizedRevenue();
		if ( BigDecimal.ZERO.compareTo(annualizedRevenue) == 0 )
		{
			return null;
		}
		if ( annualize )
		{
			dividend = dividend.multiply(getAnnualMultiplier());
		}
		return dividend.divide(annualizedRevenue, 2, RoundingMode.FLOOR);
	}
	
	private BigDecimal calculateRatioToFreeCashFlow(BigDecimal dividend, boolean annualize)
	{
		if (stockPrice == null)
		{
			return null;
		}
		BigDecimal annualizedRevenue = getAnnualizedRevenue();
		if ( BigDecimal.ZERO.compareTo(annualizedRevenue) == 0 )
		{
			return null;
		}
		if ( annualize )
		{
			dividend = dividend.multiply(getAnnualizedFreeCashFlow());
		}
		return dividend.divide(annualizedRevenue, 2, RoundingMode.FLOOR);
	}
	
	public boolean hasProperty(String property)
	{
		Object[] beans = { this, incomeStatement, balanceSheet, cashFlow };
		for ( int n=0; n<beans.length; n++ )
		{
			BeanMap map = new BeanMap(beans[n]);
			if ( map.getReadMethod(property) != null )
			{
				return true;
			}
		}
		return false;
	}
	
	public Object getProperty(String property)
	{
		Object[] beans = { this, incomeStatement, balanceSheet, cashFlow };
		for ( int n=0; n<beans.length; n++ )
		{
			BeanMap map = new BeanMap(beans[n]);
			if ( map.getReadMethod(property) != null )
			{
				return map.get(property);
			}
		}
		throw new RuntimeException("No such property: " + property);
	}
	
	public BigDecimal getBigDecimalProperty(String property)
	{
		Object value = this.getProperty(property);
		if ( value == null ) return null;
		return (BigDecimal)value;
	}
	
	public Map<String, Percentage> getChangeFromPreviousMap()
	{
		return new SimpleMap<String, Percentage>()
		{
			public boolean containsKey(Object key)
			{
				return hasProperty((String)key);
			}

			public Percentage get(Object key)
			{
				return getChangeFromPrevious((String)key);
			}
		};
	}
	
	public Map<String, Percentage> getChangeFromEarliestMap()
	{
		return new SimpleMap<String, Percentage>()
		{
			public boolean containsKey(Object key)
			{
				return hasProperty((String)key);
			}

			public Percentage get(Object key)
			{
				return getChangeFromEarliest((String)key);
			}
		};
	}
	
	public Map<String, Object> getPropertyMap()
	{
		return new SimpleMap<String, Object>()
		{
			public boolean containsKey(Object key)
			{
				return hasProperty((String)key);
			}

			public Object get(Object key)
			{
				return getProperty((String)key);
			}
		};
	}
	
	public Percentage getChangeFromPrevious(String property)
	{
		Report previousReport = getPreviousReport();
		if ( previousReport == null )
		{
			return null;
		}
		Report report = this;
		if ( previousReport == null ) return null;
		BigDecimal value = report.getBigDecimalProperty(property);
		if ( value == null )
		{
			return null;
		}
		BigDecimal previousValue = previousReport.getBigDecimalProperty(property);
		if ( previousValue == null )
		{
			return null;
		}
		return new Percentage(value.subtract(previousValue).divide(previousValue, 2, RoundingMode.CEILING));
	}
	
	public Percentage getChangeFromEarliest(String property)
	{
		if ( reportSource == null )
		{
			return null;
		}
		Report report = this;
		Report previousReport = reportSource.findEarliestReport();
		BigDecimal value = report.getBigDecimalProperty(property);
		if ( value == null )
		{
			return null;
		}
		BigDecimal previousValue = previousReport.getBigDecimalProperty(property);
		if ( previousValue == null || previousValue.floatValue() == 0 )
		{
			return null;
		}
		return new Percentage(value.subtract(previousValue).divide(previousValue, 2, RoundingMode.CEILING));
	}
	
	public int compareTo(Report o)
	{
		return getReportTime().compareTo(o.getReportTime());
	}
	
	public boolean equals(Object o)
	{
		return getReportTime().equals(((Report)o).getReportTime());
	}
	
	public int hashCode()
	{
		return getReportTime().hashCode();
	}
}
