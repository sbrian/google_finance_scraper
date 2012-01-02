package com.sbrian.gfinance.scraper;

import java.math.BigDecimal;

public class CashFlow extends Subtractable
{
	private BigDecimal netIncomeAndStartingLine = ZERO;
	private BigDecimal depreciationAndDepletion = ZERO;
	private BigDecimal amortization = ZERO;
	private BigDecimal deferredTaxes = ZERO;
	private BigDecimal nonCashItems = ZERO;
	private BigDecimal changesInWorkingCapital = ZERO;
	private BigDecimal cashFromOperatingActivities = ZERO;
	private BigDecimal capitalExpenditures = ZERO;
	private BigDecimal totalOtherInvestingCashFlowItems = ZERO;
	private BigDecimal cashFromInvestingActivities = ZERO;
	private BigDecimal financingCashFlowItems = ZERO;
	private BigDecimal totalCashDividendsPaid = ZERO;
	private BigDecimal netIssuanceOfStock = ZERO;
	private BigDecimal netIssuanceOfDebt = ZERO;
	private BigDecimal cashFromFinancingActivities = ZERO;
	private BigDecimal foreignExchangeEffects = ZERO;
	private BigDecimal netChangeInCash = ZERO;
	private BigDecimal supplementalCashInterestPaid = ZERO;
	private BigDecimal supplementalCashTaxesPaid = ZERO;
	public BigDecimal getNetIncomeAndStartingLine()
	{
		return netIncomeAndStartingLine;
	}
	public void setNetIncomeAndStartingLine(BigDecimal netIncomeAndStartingLine)
	{
		this.netIncomeAndStartingLine = netIncomeAndStartingLine;
	}
	public BigDecimal getDepreciationAndDepletion()
	{
		return depreciationAndDepletion;
	}
	public void setDepreciationAndDepletion(BigDecimal depreciationAndDepletion)
	{
		this.depreciationAndDepletion = depreciationAndDepletion;
	}
	public BigDecimal getAmortization()
	{
		return amortization;
	}
	public void setAmortization(BigDecimal amortization)
	{
		this.amortization = amortization;
	}
	public BigDecimal getDeferredTaxes()
	{
		return deferredTaxes;
	}
	public void setDeferredTaxes(BigDecimal deferredTaxes)
	{
		this.deferredTaxes = deferredTaxes;
	}
	public BigDecimal getNonCashItems()
	{
		return nonCashItems;
	}
	public void setNonCashItems(BigDecimal nonCashItems)
	{
		this.nonCashItems = nonCashItems;
	}
	public BigDecimal getChangesInWorkingCapital()
	{
		return changesInWorkingCapital;
	}
	public void setChangesInWorkingCapital(BigDecimal changesInWorkingCapital)
	{
		this.changesInWorkingCapital = changesInWorkingCapital;
	}
	public BigDecimal getCashFromOperatingActivities()
	{
		return cashFromOperatingActivities;
	}
	public void setCashFromOperatingActivities(
			BigDecimal cashFromOperatingActivities)
	{
		this.cashFromOperatingActivities = cashFromOperatingActivities;
	}
	public BigDecimal getCapitalExpenditures()
	{
		return capitalExpenditures;
	}
	public void setCapitalExpenditures(BigDecimal capitalExpenditures)
	{
		this.capitalExpenditures = capitalExpenditures;
	}
	public BigDecimal getTotalOtherInvestingCashFlowItems()
	{
		return totalOtherInvestingCashFlowItems;
	}
	public void setTotalOtherInvestingCashFlowItems(
			BigDecimal totalOtherInvestingCashFlowItems)
	{
		this.totalOtherInvestingCashFlowItems = totalOtherInvestingCashFlowItems;
	}
	public BigDecimal getCashFromInvestingActivities()
	{
		return cashFromInvestingActivities;
	}
	public void setCashFromInvestingActivities(
			BigDecimal cashFromInvestingActivities)
	{
		this.cashFromInvestingActivities = cashFromInvestingActivities;
	}
	public BigDecimal getFinancingCashFlowItems()
	{
		return financingCashFlowItems;
	}
	public void setFinancingCashFlowItems(BigDecimal financingCashFlowItems)
	{
		this.financingCashFlowItems = financingCashFlowItems;
	}
	public BigDecimal getTotalCashDividendsPaid()
	{
		return totalCashDividendsPaid;
	}
	public void setTotalCashDividendsPaid(BigDecimal totalCashDividendsPaid)
	{
		this.totalCashDividendsPaid = totalCashDividendsPaid;
	}
	public BigDecimal getNetIssuanceOfStock()
	{
		return netIssuanceOfStock;
	}
	public void setNetIssuanceOfStock(BigDecimal netIssuanceOfStock)
	{
		this.netIssuanceOfStock = netIssuanceOfStock;
	}
	public BigDecimal getNetIssuanceOfDebt()
	{
		return netIssuanceOfDebt;
	}
	public void setNetIssuanceOfDebt(BigDecimal netIssuanceOfDebt)
	{
		this.netIssuanceOfDebt = netIssuanceOfDebt;
	}
	public BigDecimal getCashFromFinancingActivities()
	{
		return cashFromFinancingActivities;
	}
	public void setCashFromFinancingActivities(
			BigDecimal cashFromFinancingActivities)
	{
		this.cashFromFinancingActivities = cashFromFinancingActivities;
	}
	public BigDecimal getForeignExchangeEffects()
	{
		return foreignExchangeEffects;
	}
	public void setForeignExchangeEffects(BigDecimal foreignExchangeEffects)
	{
		this.foreignExchangeEffects = foreignExchangeEffects;
	}
	public BigDecimal getNetChangeInCash()
	{
		return netChangeInCash;
	}
	public void setNetChangeInCash(BigDecimal netChangeInCash)
	{
		this.netChangeInCash = netChangeInCash;
	}
	public BigDecimal getSupplementalCashInterestPaid()
	{
		return supplementalCashInterestPaid;
	}
	public void setSupplementalCashInterestPaid(
			BigDecimal supplementalCashInterestPaid)
	{
		this.supplementalCashInterestPaid = supplementalCashInterestPaid;
	}
	public BigDecimal getSupplementalCashTaxesPaid()
	{
		return supplementalCashTaxesPaid;
	}
	public void setSupplementalCashTaxesPaid(BigDecimal supplementalCashTaxesPaid)
	{
		this.supplementalCashTaxesPaid = supplementalCashTaxesPaid;
	}
}
