package com.sbrian.gfinance.scraper;

import java.math.BigDecimal;

public class IncomeStatement extends Subtractable
{
	private BigDecimal revenue = ZERO;
	private BigDecimal totalOtherRevenue = ZERO;
	private BigDecimal totalRevenue = ZERO;
	private BigDecimal totalCostOfRevenue = ZERO;
	private BigDecimal grossProfit = ZERO;
	private BigDecimal totalSellingAndGeneralAndAdminExpenses = ZERO;
	private BigDecimal researchAndDevelopment = ZERO;
	private BigDecimal depreciationAndAmortization = ZERO;
	private BigDecimal interestExpenseNetOperating = ZERO;
	private BigDecimal unusualExpense = ZERO;
	private BigDecimal totalOtherOperatingExpenses = ZERO;
	private BigDecimal totalOperatingExpense = ZERO;
	private BigDecimal operatingIncome = ZERO;
	private BigDecimal netNonOperatingInterestIncome = ZERO;
	private BigDecimal gainOnSaleOfAssets = ZERO;
	private BigDecimal netOther = ZERO;
	private BigDecimal incomeBeforeTax = ZERO;
	private BigDecimal incomeAfterTax = ZERO;
	private BigDecimal minorityInterest = ZERO;
	private BigDecimal equityInAffiliates = ZERO;
	private BigDecimal netIncomeBeforeExtraItems = ZERO;
	private BigDecimal accountingChange = ZERO;
	private BigDecimal discontinuedOperations = ZERO;
	private BigDecimal extraordinaryItem = ZERO;
	private BigDecimal netIncome = ZERO;
	private BigDecimal preferredDividends = ZERO;
	private BigDecimal incomeAvailableToCommonExclExtraItems = ZERO;
	private BigDecimal incomeAvailableToCommonInclExtraItems = ZERO;
	private BigDecimal basicWeightedAverageShares = ZERO;
	private BigDecimal basicEPSExcludingExtraordinaryItems = ZERO;
	private BigDecimal basicEPSIncludingExtraordinaryItems = ZERO;
	private BigDecimal dilutionAdjustment = ZERO;
	private BigDecimal dilutedWeightedAverageShares = ZERO;
	private BigDecimal dilutedEPSExcludingExtraordinaryItems = ZERO;
	private BigDecimal dilutedEPSIncludingExtraordinaryItems = ZERO;
	private BigDecimal dividendsPerShareCommonStockPrimaryIssue = ZERO;
	private BigDecimal grossDividendsCommonStock = ZERO;
	private BigDecimal netIncomeAfterStockBasedCompExpense = ZERO;
	private BigDecimal basicEPSAfterStockBasedCompExpense = ZERO;
	private BigDecimal dilutedEPSAfterStockBasedCompExpense = ZERO;
	private BigDecimal supplementalDepreciation = ZERO;
	private BigDecimal totalSpecialItems = ZERO;
	private BigDecimal normalizedIncomeBeforeTaxes = ZERO;
	private BigDecimal effectOfSpecialItemsOnIncomeTaxes = ZERO;
	private BigDecimal incomeTaxesExImpactOfSpecialItems = ZERO;
	private BigDecimal normalizedIncomeAfterTaxes = ZERO;
	private BigDecimal normalizedIncomeAvailToCommon = ZERO;
	private BigDecimal basicNormalizedEPS = ZERO;
	private BigDecimal dilutedNormalizedEPS = ZERO;
	public BigDecimal getRevenue()
	{
		return revenue;
	}
	public void setRevenue(BigDecimal revenue)
	{
		this.revenue = revenue;
	}
	public BigDecimal getTotalOtherRevenue()
	{
		return totalOtherRevenue;
	}
	public void setTotalOtherRevenue(BigDecimal totalOtherRevenue)
	{
		this.totalOtherRevenue = totalOtherRevenue;
	}
	public BigDecimal getTotalRevenue()
	{
		return totalRevenue;
	}
	public void setTotalRevenue(BigDecimal totalRevenue)
	{
		this.totalRevenue = totalRevenue;
	}
	public BigDecimal getTotalCostOfRevenue()
	{
		return totalCostOfRevenue;
	}
	public void setTotalCostOfRevenue(BigDecimal totalCostOfRevenue)
	{
		this.totalCostOfRevenue = totalCostOfRevenue;
	}
	public BigDecimal getGrossProfit()
	{
		return grossProfit;
	}
	public void setGrossProfit(BigDecimal grossProfit)
	{
		this.grossProfit = grossProfit;
	}
	public BigDecimal getTotalSellingAndGeneralAndAdminExpenses()
	{
		return totalSellingAndGeneralAndAdminExpenses;
	}
	public void setTotalSellingAndGeneralAndAdminExpenses(
			BigDecimal totalSellingAndGeneralAndAdminExpenses)
	{
		this.totalSellingAndGeneralAndAdminExpenses = totalSellingAndGeneralAndAdminExpenses;
	}
	public BigDecimal getResearchAndDevelopment()
	{
		return researchAndDevelopment;
	}
	public void setResearchAndDevelopment(BigDecimal researchAndDevelopment)
	{
		this.researchAndDevelopment = researchAndDevelopment;
	}
	public BigDecimal getDepreciationAndAmortization()
	{
		return depreciationAndAmortization;
	}
	public void setDepreciationAndAmortization(
			BigDecimal depreciationAndAmortization)
	{
		this.depreciationAndAmortization = depreciationAndAmortization;
	}
	public BigDecimal getInterestExpenseNetOperating()
	{
		return interestExpenseNetOperating;
	}
	public void setInterestExpenseNetOperating(
			BigDecimal interestExpenseNetOperating)
	{
		this.interestExpenseNetOperating = interestExpenseNetOperating;
	}
	public BigDecimal getUnusualExpense()
	{
		return unusualExpense;
	}
	public void setUnusualExpense(BigDecimal unusualExpense)
	{
		this.unusualExpense = unusualExpense;
	}
	public BigDecimal getTotalOtherOperatingExpenses()
	{
		return totalOtherOperatingExpenses;
	}
	public void setTotalOtherOperatingExpenses(
			BigDecimal totalOtherOperatingExpenses)
	{
		this.totalOtherOperatingExpenses = totalOtherOperatingExpenses;
	}
	public BigDecimal getTotalOperatingExpense()
	{
		return totalOperatingExpense;
	}
	public void setTotalOperatingExpense(BigDecimal totalOperatingExpense)
	{
		this.totalOperatingExpense = totalOperatingExpense;
	}
	public BigDecimal getOperatingIncome()
	{
		return operatingIncome;
	}
	public void setOperatingIncome(BigDecimal operatingIncome)
	{
		this.operatingIncome = operatingIncome;
	}
	public BigDecimal getNetNonOperatingInterestIncome()
	{
		return netNonOperatingInterestIncome;
	}
	public void setNetNonOperatingInterestIncome(
			BigDecimal netNonOperatingInterestIncome)
	{
		this.netNonOperatingInterestIncome = netNonOperatingInterestIncome;
	}
	public BigDecimal getGainOnSaleOfAssets()
	{
		return gainOnSaleOfAssets;
	}
	public void setGainOnSaleOfAssets(BigDecimal gainOnSaleOfAssets)
	{
		this.gainOnSaleOfAssets = gainOnSaleOfAssets;
	}
	public BigDecimal getNetOther()
	{
		return netOther;
	}
	public void setNetOther(BigDecimal netOther)
	{
		this.netOther = netOther;
	}
	public BigDecimal getIncomeBeforeTax()
	{
		return incomeBeforeTax;
	}
	public void setIncomeBeforeTax(BigDecimal incomeBeforeTax)
	{
		this.incomeBeforeTax = incomeBeforeTax;
	}
	public BigDecimal getIncomeAfterTax()
	{
		return incomeAfterTax;
	}
	public void setIncomeAfterTax(BigDecimal incomeAfterTax)
	{
		this.incomeAfterTax = incomeAfterTax;
	}
	public BigDecimal getMinorityInterest()
	{
		return minorityInterest;
	}
	public void setMinorityInterest(BigDecimal minorityInterest)
	{
		this.minorityInterest = minorityInterest;
	}
	public BigDecimal getEquityInAffiliates()
	{
		return equityInAffiliates;
	}
	public void setEquityInAffiliates(BigDecimal equityInAffiliates)
	{
		this.equityInAffiliates = equityInAffiliates;
	}
	public BigDecimal getNetIncomeBeforeExtraItems()
	{
		return netIncomeBeforeExtraItems;
	}
	public void setNetIncomeBeforeExtraItems(BigDecimal netIncomeBeforeExtraItems)
	{
		this.netIncomeBeforeExtraItems = netIncomeBeforeExtraItems;
	}
	public BigDecimal getAccountingChange()
	{
		return accountingChange;
	}
	public void setAccountingChange(BigDecimal accountingChange)
	{
		this.accountingChange = accountingChange;
	}
	public BigDecimal getDiscontinuedOperations()
	{
		return discontinuedOperations;
	}
	public void setDiscontinuedOperations(BigDecimal discontinuedOperations)
	{
		this.discontinuedOperations = discontinuedOperations;
	}
	public BigDecimal getExtraordinaryItem()
	{
		return extraordinaryItem;
	}
	public void setExtraordinaryItem(BigDecimal extraordinaryItem)
	{
		this.extraordinaryItem = extraordinaryItem;
	}
	public BigDecimal getNetIncome()
	{
		return netIncome;
	}
	public void setNetIncome(BigDecimal netIncome)
	{
		this.netIncome = netIncome;
	}
	public BigDecimal getPreferredDividends()
	{
		return preferredDividends;
	}
	public void setPreferredDividends(BigDecimal preferredDividends)
	{
		this.preferredDividends = preferredDividends;
	}
	public BigDecimal getIncomeAvailableToCommonExclExtraItems()
	{
		return incomeAvailableToCommonExclExtraItems;
	}
	public void setIncomeAvailableToCommonExclExtraItems(
			BigDecimal incomeAvailableToCommonExclExtraItems)
	{
		this.incomeAvailableToCommonExclExtraItems = incomeAvailableToCommonExclExtraItems;
	}
	public BigDecimal getIncomeAvailableToCommonInclExtraItems()
	{
		return incomeAvailableToCommonInclExtraItems;
	}
	public void setIncomeAvailableToCommonInclExtraItems(
			BigDecimal incomeAvailableToCommonInclExtraItems)
	{
		this.incomeAvailableToCommonInclExtraItems = incomeAvailableToCommonInclExtraItems;
	}
	public BigDecimal getBasicWeightedAverageShares()
	{
		return basicWeightedAverageShares;
	}
	public void setBasicWeightedAverageShares(BigDecimal basicWeightedAverageShares)
	{
		this.basicWeightedAverageShares = basicWeightedAverageShares;
	}
	public BigDecimal getBasicEPSExcludingExtraordinaryItems()
	{
		return basicEPSExcludingExtraordinaryItems;
	}
	public void setBasicEPSExcludingExtraordinaryItems(
			BigDecimal basicEPSExcludingExtraordinaryItems)
	{
		this.basicEPSExcludingExtraordinaryItems = basicEPSExcludingExtraordinaryItems;
	}
	public BigDecimal getBasicEPSIncludingExtraordinaryItems()
	{
		return basicEPSIncludingExtraordinaryItems;
	}
	public void setBasicEPSIncludingExtraordinaryItems(
			BigDecimal basicEPSIncludingExtraordinaryItems)
	{
		this.basicEPSIncludingExtraordinaryItems = basicEPSIncludingExtraordinaryItems;
	}
	public BigDecimal getDilutionAdjustment()
	{
		return dilutionAdjustment;
	}
	public void setDilutionAdjustment(BigDecimal dilutionAdjustment)
	{
		this.dilutionAdjustment = dilutionAdjustment;
	}
	public BigDecimal getDilutedWeightedAverageShares()
	{
		return dilutedWeightedAverageShares;
	}
	public void setDilutedWeightedAverageShares(
			BigDecimal dilutedWeightedAverageShares)
	{
		this.dilutedWeightedAverageShares = dilutedWeightedAverageShares;
	}
	public BigDecimal getDilutedEPSExcludingExtraordinaryItems()
	{
		return dilutedEPSExcludingExtraordinaryItems;
	}
	public void setDilutedEPSExcludingExtraordinaryItems(
			BigDecimal dilutedEPSExcludingExtraordinaryItems)
	{
		this.dilutedEPSExcludingExtraordinaryItems = dilutedEPSExcludingExtraordinaryItems;
	}
	public BigDecimal getDilutedEPSIncludingExtraordinaryItems()
	{
		return dilutedEPSIncludingExtraordinaryItems;
	}
	public void setDilutedEPSIncludingExtraordinaryItems(
			BigDecimal dilutedEPSIncludingExtraordinaryItems)
	{
		this.dilutedEPSIncludingExtraordinaryItems = dilutedEPSIncludingExtraordinaryItems;
	}
	public BigDecimal getDividendsPerShareCommonStockPrimaryIssue()
	{
		return dividendsPerShareCommonStockPrimaryIssue;
	}
	public void setDividendsPerShareCommonStockPrimaryIssue(
			BigDecimal dividendsPerShareCommonStockPrimaryIssue)
	{
		this.dividendsPerShareCommonStockPrimaryIssue = dividendsPerShareCommonStockPrimaryIssue;
	}
	public BigDecimal getGrossDividendsCommonStock()
	{
		return grossDividendsCommonStock;
	}
	public void setGrossDividendsCommonStock(BigDecimal grossDividendsCommonStock)
	{
		this.grossDividendsCommonStock = grossDividendsCommonStock;
	}
	public BigDecimal getNetIncomeAfterStockBasedCompExpense()
	{
		return netIncomeAfterStockBasedCompExpense;
	}
	public void setNetIncomeAfterStockBasedCompExpense(
			BigDecimal netIncomeAfterStockBasedCompExpense)
	{
		this.netIncomeAfterStockBasedCompExpense = netIncomeAfterStockBasedCompExpense;
	}
	public BigDecimal getBasicEPSAfterStockBasedCompExpense()
	{
		return basicEPSAfterStockBasedCompExpense;
	}
	public void setBasicEPSAfterStockBasedCompExpense(
			BigDecimal basicEPSAfterStockBasedCompExpense)
	{
		this.basicEPSAfterStockBasedCompExpense = basicEPSAfterStockBasedCompExpense;
	}
	public BigDecimal getDilutedEPSAfterStockBasedCompExpense()
	{
		return dilutedEPSAfterStockBasedCompExpense;
	}
	public void setDilutedEPSAfterStockBasedCompExpense(
			BigDecimal dilutedEPSAfterStockBasedCompExpense)
	{
		this.dilutedEPSAfterStockBasedCompExpense = dilutedEPSAfterStockBasedCompExpense;
	}
	public BigDecimal getSupplementalDepreciation()
	{
		return supplementalDepreciation;
	}
	public void setSupplementalDepreciation(BigDecimal supplementalDepreciation)
	{
		this.supplementalDepreciation = supplementalDepreciation;
	}
	public BigDecimal getTotalSpecialItems()
	{
		return totalSpecialItems;
	}
	public void setTotalSpecialItems(BigDecimal totalSpecialItems)
	{
		this.totalSpecialItems = totalSpecialItems;
	}
	public BigDecimal getNormalizedIncomeBeforeTaxes()
	{
		return normalizedIncomeBeforeTaxes;
	}
	public void setNormalizedIncomeBeforeTaxes(
			BigDecimal normalizedIncomeBeforeTaxes)
	{
		this.normalizedIncomeBeforeTaxes = normalizedIncomeBeforeTaxes;
	}
	public BigDecimal getEffectOfSpecialItemsOnIncomeTaxes()
	{
		return effectOfSpecialItemsOnIncomeTaxes;
	}
	public void setEffectOfSpecialItemsOnIncomeTaxes(
			BigDecimal effectOfSpecialItemsOnIncomeTaxes)
	{
		this.effectOfSpecialItemsOnIncomeTaxes = effectOfSpecialItemsOnIncomeTaxes;
	}
	public BigDecimal getIncomeTaxesExImpactOfSpecialItems()
	{
		return incomeTaxesExImpactOfSpecialItems;
	}
	public void setIncomeTaxesExImpactOfSpecialItems(
			BigDecimal incomeTaxesExImpactOfSpecialItems)
	{
		this.incomeTaxesExImpactOfSpecialItems = incomeTaxesExImpactOfSpecialItems;
	}
	public BigDecimal getNormalizedIncomeAfterTaxes()
	{
		return normalizedIncomeAfterTaxes;
	}
	public void setNormalizedIncomeAfterTaxes(BigDecimal normalizedIncomeAfterTaxes)
	{
		this.normalizedIncomeAfterTaxes = normalizedIncomeAfterTaxes;
	}
	public BigDecimal getNormalizedIncomeAvailToCommon()
	{
		return normalizedIncomeAvailToCommon;
	}
	public void setNormalizedIncomeAvailToCommon(
			BigDecimal normalizedIncomeAvailToCommon)
	{
		this.normalizedIncomeAvailToCommon = normalizedIncomeAvailToCommon;
	}
	public BigDecimal getBasicNormalizedEPS()
	{
		return basicNormalizedEPS;
	}
	public void setBasicNormalizedEPS(BigDecimal basicNormalizedEPS)
	{
		this.basicNormalizedEPS = basicNormalizedEPS;
	}
	public BigDecimal getDilutedNormalizedEPS()
	{
		return dilutedNormalizedEPS;
	}
	public void setDilutedNormalizedEPS(BigDecimal dilutedNormalizedEPS)
	{
		this.dilutedNormalizedEPS = dilutedNormalizedEPS;
	}
}
