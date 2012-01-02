package com.sbrian.gfinance.scraper;

import java.math.BigDecimal;

public class BalanceSheet extends BaseObject
{
	private Date date;
	private BigDecimal cashAndEquivalents = ZERO;
	private BigDecimal shortTermInvestments = ZERO;
	private BigDecimal cashAndShortTermInvestments = ZERO;
	private BigDecimal netAccountsReceivableTrade = ZERO;
	private BigDecimal receivablesOther = ZERO;
	private BigDecimal netTotalReceivables = ZERO;
	private BigDecimal totalInventory = ZERO;
	private BigDecimal prepaidExpenses = ZERO;
	private BigDecimal totalOtherCurrentAssets = ZERO;
	private BigDecimal totalCurrentAssets = ZERO;
	private BigDecimal totalGrossPropertyAndPlantAndEquipment = ZERO;
	private BigDecimal totalAccumulatedDepreciation = ZERO;
	private BigDecimal netGoodwill = ZERO;
	private BigDecimal netIntangibles = ZERO;
	private BigDecimal longTermInvestments = ZERO;
	private BigDecimal totalOtherLongTermAssets = ZERO;
	private BigDecimal totalAssets = ZERO;
	private BigDecimal accountsPayable = ZERO;
	private BigDecimal accruedExpenses = ZERO;
	private BigDecimal notesPayableAndShortTermDebt = ZERO;
	private BigDecimal currentPortOfLTDebtAndCapitalLeases = ZERO;
	private BigDecimal totalOtherCurrentLiabilities = ZERO;
	private BigDecimal totalCurrentLiabilities = ZERO;
	private BigDecimal longTermDebt = ZERO;
	private BigDecimal capitalLeaseObligations = ZERO;
	private BigDecimal totalLongTermDebt = ZERO;
	private BigDecimal totalDebt = ZERO;
	private BigDecimal deferredIncomeTax = ZERO;
	private BigDecimal minorityInterest = ZERO;
	private BigDecimal totalOtherLiabilities = ZERO;
	private BigDecimal totalLiabilities = ZERO;
	private BigDecimal totalRedeemablePreferredStock = ZERO;
	private BigDecimal netPreferredStockNonRedeemable = ZERO;
	private BigDecimal totalCommonStock = ZERO;
	private BigDecimal additionalPaidInCapital = ZERO;
	private BigDecimal retainedEarnings  = ZERO;
	private BigDecimal treasuryStockCommon = ZERO;
	private BigDecimal totalOtherEquity = ZERO;
	private BigDecimal totalEquity = ZERO;
	private BigDecimal totalLiabilitiesAndShareholdersEquity = ZERO;
	private BigDecimal sharesOutsCommonStockPrimaryIssue = ZERO;
	private Long totalCommonSharesOutstanding;
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public BigDecimal getCashAndEquivalents()
	{
		return cashAndEquivalents;
	}
	public void setCashAndEquivalents(BigDecimal cashAndEquivalents)
	{
		this.cashAndEquivalents = cashAndEquivalents;
	}
	public BigDecimal getShortTermInvestments()
	{
		return shortTermInvestments;
	}
	public void setShortTermInvestments(BigDecimal shortTermInvestments)
	{
		this.shortTermInvestments = shortTermInvestments;
	}
	public BigDecimal getCashAndShortTermInvestments()
	{
		return cashAndShortTermInvestments;
	}
	public void setCashAndShortTermInvestments(
			BigDecimal cashAndShortTermInvestments)
	{
		this.cashAndShortTermInvestments = cashAndShortTermInvestments;
	}
	public BigDecimal getNetAccountsReceivableTrade()
	{
		return netAccountsReceivableTrade;
	}
	public void setNetAccountsReceivableTrade(BigDecimal netAccountsReceivableTrade)
	{
		this.netAccountsReceivableTrade = netAccountsReceivableTrade;
	}
	public BigDecimal getReceivablesOther()
	{
		return receivablesOther;
	}
	public void setReceivablesOther(BigDecimal receivablesOther)
	{
		this.receivablesOther = receivablesOther;
	}
	public BigDecimal getNetTotalReceivables()
	{
		return netTotalReceivables;
	}
	public void setNetTotalReceivables(BigDecimal netTotalReceivables)
	{
		this.netTotalReceivables = netTotalReceivables;
	}
	public BigDecimal getTotalInventory()
	{
		return totalInventory;
	}
	public void setTotalInventory(BigDecimal totalInventory)
	{
		this.totalInventory = totalInventory;
	}
	public BigDecimal getPrepaidExpenses()
	{
		return prepaidExpenses;
	}
	public void setPrepaidExpenses(BigDecimal prepaidExpenses)
	{
		this.prepaidExpenses = prepaidExpenses;
	}
	public BigDecimal getTotalOtherCurrentAssets()
	{
		return totalOtherCurrentAssets;
	}
	public void setTotalOtherCurrentAssets(BigDecimal totalOtherCurrentAssets)
	{
		this.totalOtherCurrentAssets = totalOtherCurrentAssets;
	}
	public BigDecimal getTotalCurrentAssets()
	{
		return totalCurrentAssets;
	}
	public void setTotalCurrentAssets(BigDecimal totalCurrentAssets)
	{
		this.totalCurrentAssets = totalCurrentAssets;
	}
	public BigDecimal getTotalGrossPropertyAndPlantAndEquipment()
	{
		return totalGrossPropertyAndPlantAndEquipment;
	}
	public void setTotalGrossPropertyAndPlantAndEquipment(
			BigDecimal totalGrossPropertyAndPlantAndEquipment)
	{
		this.totalGrossPropertyAndPlantAndEquipment = totalGrossPropertyAndPlantAndEquipment;
	}
	public BigDecimal getTotalAccumulatedDepreciation()
	{
		return totalAccumulatedDepreciation;
	}
	public void setTotalAccumulatedDepreciation(
			BigDecimal totalAccumulatedDepreciation)
	{
		this.totalAccumulatedDepreciation = totalAccumulatedDepreciation;
	}
	public BigDecimal getNetGoodwill()
	{
		return netGoodwill;
	}
	public void setNetGoodwill(BigDecimal netGoodwill)
	{
		this.netGoodwill = netGoodwill;
	}
	public BigDecimal getNetIntangibles()
	{
		return netIntangibles;
	}
	public void setNetIntangibles(BigDecimal netIntangibles)
	{
		this.netIntangibles = netIntangibles;
	}
	public BigDecimal getLongTermInvestments()
	{
		return longTermInvestments;
	}
	public void setLongTermInvestments(BigDecimal longTermInvestments)
	{
		this.longTermInvestments = longTermInvestments;
	}
	public BigDecimal getTotalOtherLongTermAssets()
	{
		return totalOtherLongTermAssets;
	}
	public void setTotalOtherLongTermAssets(BigDecimal totalOtherLongTermAssets)
	{
		this.totalOtherLongTermAssets = totalOtherLongTermAssets;
	}
	public BigDecimal getTotalAssets()
	{
		return totalAssets;
	}
	public void setTotalAssets(BigDecimal totalAssets)
	{
		this.totalAssets = totalAssets;
	}
	public BigDecimal getAccountsPayable()
	{
		return accountsPayable;
	}
	public void setAccountsPayable(BigDecimal accountsPayable)
	{
		this.accountsPayable = accountsPayable;
	}
	public BigDecimal getAccruedExpenses()
	{
		return accruedExpenses;
	}
	public void setAccruedExpenses(BigDecimal accruedExpenses)
	{
		this.accruedExpenses = accruedExpenses;
	}
	public BigDecimal getNotesPayableAndShortTermDebt()
	{
		return notesPayableAndShortTermDebt;
	}
	public void setNotesPayableAndShortTermDebt(
			BigDecimal notesPayableAndShortTermDebt)
	{
		this.notesPayableAndShortTermDebt = notesPayableAndShortTermDebt;
	}
	public BigDecimal getCurrentPortOfLTDebtAndCapitalLeases()
	{
		return currentPortOfLTDebtAndCapitalLeases;
	}
	public void setCurrentPortOfLTDebtAndCapitalLeases(
			BigDecimal currentPortOfLTDebtAndCapitalLeases)
	{
		this.currentPortOfLTDebtAndCapitalLeases = currentPortOfLTDebtAndCapitalLeases;
	}
	public BigDecimal getTotalOtherCurrentLiabilities()
	{
		return totalOtherCurrentLiabilities;
	}
	public void setTotalOtherCurrentLiabilities(
			BigDecimal totalOtherCurrentLiabilities)
	{
		this.totalOtherCurrentLiabilities = totalOtherCurrentLiabilities;
	}
	public BigDecimal getTotalCurrentLiabilities()
	{
		return totalCurrentLiabilities;
	}
	public void setTotalCurrentLiabilities(BigDecimal totalCurrentLiabilities)
	{
		this.totalCurrentLiabilities = totalCurrentLiabilities;
	}
	public BigDecimal getLongTermDebt()
	{
		return longTermDebt;
	}
	public void setLongTermDebt(BigDecimal longTermDebt)
	{
		this.longTermDebt = longTermDebt;
	}
	public BigDecimal getCapitalLeaseObligations()
	{
		return capitalLeaseObligations;
	}
	public void setCapitalLeaseObligations(BigDecimal capitalLeaseObligations)
	{
		this.capitalLeaseObligations = capitalLeaseObligations;
	}
	public BigDecimal getTotalLongTermDebt()
	{
		return totalLongTermDebt;
	}
	public void setTotalLongTermDebt(BigDecimal totalLongTermDebt)
	{
		this.totalLongTermDebt = totalLongTermDebt;
	}
	public BigDecimal getTotalDebt()
	{
		return totalDebt;
	}
	public void setTotalDebt(BigDecimal totalDebt)
	{
		this.totalDebt = totalDebt;
	}
	public BigDecimal getDeferredIncomeTax()
	{
		return deferredIncomeTax;
	}
	public void setDeferredIncomeTax(BigDecimal deferredIncomeTax)
	{
		this.deferredIncomeTax = deferredIncomeTax;
	}
	public BigDecimal getMinorityInterest()
	{
		return minorityInterest;
	}
	public void setMinorityInterest(BigDecimal minorityInterest)
	{
		this.minorityInterest = minorityInterest;
	}
	public BigDecimal getTotalOtherLiabilities()
	{
		return totalOtherLiabilities;
	}
	public void setTotalOtherLiabilities(BigDecimal totalOtherLiabilities)
	{
		this.totalOtherLiabilities = totalOtherLiabilities;
	}
	public BigDecimal getTotalLiabilities()
	{
		return totalLiabilities;
	}
	public void setTotalLiabilities(BigDecimal totalLiabilities)
	{
		this.totalLiabilities = totalLiabilities;
	}
	public BigDecimal getTotalRedeemablePreferredStock()
	{
		return totalRedeemablePreferredStock;
	}
	public void setTotalRedeemablePreferredStock(
			BigDecimal totalRedeemablePreferredStock)
	{
		this.totalRedeemablePreferredStock = totalRedeemablePreferredStock;
	}
	public BigDecimal getNetPreferredStockNonRedeemable()
	{
		return netPreferredStockNonRedeemable;
	}
	public void setNetPreferredStockNonRedeemable(
			BigDecimal netPreferredStockNonRedeemable)
	{
		this.netPreferredStockNonRedeemable = netPreferredStockNonRedeemable;
	}
	public BigDecimal getTotalCommonStock()
	{
		return totalCommonStock;
	}
	public void setTotalCommonStock(BigDecimal totalCommonStock)
	{
		this.totalCommonStock = totalCommonStock;
	}
	public BigDecimal getAdditionalPaidInCapital()
	{
		return additionalPaidInCapital;
	}
	public void setAdditionalPaidInCapital(BigDecimal additionalPaidInCapital)
	{
		this.additionalPaidInCapital = additionalPaidInCapital;
	}
	public BigDecimal getRetainedEarnings()
	{
		return retainedEarnings;
	}
	public void setRetainedEarnings(BigDecimal retainedEarnings)
	{
		this.retainedEarnings = retainedEarnings;
	}
	public BigDecimal getTreasuryStockCommon()
	{
		return treasuryStockCommon;
	}
	public void setTreasuryStockCommon(BigDecimal treasuryStockCommon)
	{
		this.treasuryStockCommon = treasuryStockCommon;
	}
	public BigDecimal getTotalOtherEquity()
	{
		return totalOtherEquity;
	}
	public void setTotalOtherEquity(BigDecimal totalOtherEquity)
	{
		this.totalOtherEquity = totalOtherEquity;
	}
	public BigDecimal getTotalEquity()
	{
		return totalEquity;
	}
	public void setTotalEquity(BigDecimal totalEquity)
	{
		this.totalEquity = totalEquity;
	}
	public BigDecimal getTotalLiabilitiesAndShareholdersEquity()
	{
		return totalLiabilitiesAndShareholdersEquity;
	}
	public void setTotalLiabilitiesAndShareholdersEquity(
			BigDecimal totalLiabilitiesAndShareholdersEquity)
	{
		this.totalLiabilitiesAndShareholdersEquity = totalLiabilitiesAndShareholdersEquity;
	}
	public BigDecimal getSharesOutsCommonStockPrimaryIssue()
	{
		return sharesOutsCommonStockPrimaryIssue;
	}
	public void setSharesOutsCommonStockPrimaryIssue(
			BigDecimal sharesOutsCommonStockPrimaryIssue)
	{
		this.sharesOutsCommonStockPrimaryIssue = sharesOutsCommonStockPrimaryIssue;
	}
	public Long getTotalCommonSharesOutstanding()
	{
		return totalCommonSharesOutstanding;
	}
	public void setTotalCommonSharesOutstanding(
			Long totalCommonSharesOutstanding)
	{
		this.totalCommonSharesOutstanding = totalCommonSharesOutstanding;
	}
}
