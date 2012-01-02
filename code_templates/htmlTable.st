<html>

<head>

<style type="text/css">

td { border: solid; border-width: 2px; border-color: red; font-size: 10 }

th { border: solid; border-width: 2px; border-color: blue; font-size: 10 }

</style>

    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
    
      // Load the Visualization API and the piechart package.
      google.load("visualization", "1", {packages:["corechart"]});

      
      // Set a callback to run when the Google Visualization API is loaded.
      google.setOnLoadCallback(drawChart);
      
      // Callback that creates and populates a data table, 
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

      // Create our data table.
        var data = new google.visualization.DataTable();
        
        data.addColumn('string', 'Time');
        data.addColumn('number', 'Mkt Cap');
        data.addColumn('number', 'Revenue');
        //data.addColumn('number', 'Debt');
        //data.addColumn('number', 'Book');
        //data.addColumn('number', 'FCF');
        data.addColumn('number', 'Net');
        data.addColumn('number', 'Op Income');
        
 		data.addRows([

$reports:{


          [
          '$it.propertyMap.reportTime$',
          $it.changeFromEarliestMap.marketCap; null="0"$,
          $it.changeFromEarliestMap.annualizedRevenue; null="0"$,
          //$it.changeFromEarliestMap.totalDebt; null="0"$,
          //$it.changeFromEarliestMap.bookValue; null="0"$,
          //$it.changeFromEarliestMap.annualizedFreeCashFlow; null="0"$,
          $it.changeFromEarliestMap.annualizedNetIncomeBeforeExtraItems; null="0"$,
          $it.changeFromEarliestMap.annualizedOperatingIncome; null="0"$
          ]

}; separator=","$
		]);
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
        chart.draw(data, {width: 800, height: 600, is3D: true, title: 'Change from Previous'});
      }
    </script>

</head>

<div id="chart_div"></div>


<table>

<tr>
<th>Time</th>
<th>Stock Price</th>
<th>Market Cap</th>
<th>Annualized Revenue</th>
<th>Debt</th>
<th>Book Value</th>
<th>Annualized Free Cash Flow</th>
<th>Annualized Net Income Before Extra Items</th>
<th>Annualized Operating Income</th>
<th>Price / Revenue</th>
<th>Debt / Equity</th>
<th>Debt / Revenue</th>
<th>Debt / Free Cash Flow</th>
<th>Profit Margin</th>
<th>Cash and Short Term Investments</th>
<tr>

$reports:{

<tr>
<td>$it.propertyMap.reportTime$</td>
<td>$it.stockPrice; null="Unknown"$</td>
<td>$it.marketCap; null="Unknown"$</td>
<td>$it.annualizedRevenue; null="Unknown"$</td>
<td>$it.propertyMap.totalDebt; null="Unknown"$</td>
<td>$it.bookValue; null="Unknown"$</td>
<td>$it.annualizedFreeCashFlow; null="Unknown"$</td>
<td>$it.annualizedNetIncomeBeforeExtraItems; null="Unknown"$</td>
<td>$it.annualizedOperatingIncome; null="Unknown"$</td>
<td>$it.priceToRevenue; null="Unknown"$</td>
<td>$it.debtToEquity; null="Unknown"$</td>
<td>$it.debtToRevenue; null="Unknown"$</td>
<td>$it.debtToFreeCashFlow; null="Unknown"$</td>
<td>$it.profitMargin; null="Unknown"$</td>
<td>$it.propertyMap.cashAndShortTermInvestments; null="Unknown"$</td>
</tr>

}$

</table>

</body>

</html>