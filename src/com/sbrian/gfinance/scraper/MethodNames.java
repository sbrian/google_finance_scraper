package com.sbrian.gfinance.scraper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodNames
{
	public static String convertToMethodName(String name)
	{
		// System.err.print(name + " - ");
		name = name.replaceFirst("(.*), (.*)", "$2$1");
		name = name.replaceFirst("\\(.*\\)", "");
		Matcher match = Pattern.compile(" +(.)").matcher(name);
		StringBuffer output = new StringBuffer();
		while (match.find())
		{
			match.appendReplacement(output, match.group(1).toUpperCase());
		}
		match.appendTail(output);
		name = output.toString();
		name = name.replace("-", "");
		name = name.replace("/", "And");
		name = name.replace(".", "");
		name = name.replace("'", "");
		name = name.replace("&", "And");
		name = name.substring(0, 1).toLowerCase() + name.substring(1);
		//if ( ! annual && statementPos == statementPosOffset ) System.err.println("private BigDecimal " + name + ";");
		return name;
	}
}
