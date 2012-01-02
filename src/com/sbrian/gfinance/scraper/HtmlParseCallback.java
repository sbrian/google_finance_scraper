package com.sbrian.gfinance.scraper;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class HtmlParseCallback extends HTMLEditorKit.ParserCallback
{
	public enum State
	{
		BEFORE_STATEMENT_HEADERS, READING_STATEMENT_HEADERS, FINISHED_STATEMENT_HEADERS, GETTING_DATA_NAME, GETTING_DATA, LOOKING_FOR_NEXT_DATA_NAME, LOOKING_FOR_NEXT_TABLE
	};
	
	private ParsedItems statements = new ParsedItems();
	
	private State state = State.LOOKING_FOR_NEXT_TABLE;
	private String currentName;
	private int statementPosOffset = 0;
	private int statementPos = -1;
	private int type = -1;
	private String[] types = { "IncomeStatement", "BalanceSheet", "CashFlow" };
	boolean annual = true;
	
	public void handleStartTag(HTML.Tag tag, MutableAttributeSet a, int pos)
	{
		try
		{
			_handleStartTag(tag, a, pos);
		}
		catch(Throwable t)
		{
			failHard(t);
		}
	}
	
	private void _handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos)
	{
		//System.err.println("Handle start tag: " + t);
		switch (state)
		{
		case FINISHED_STATEMENT_HEADERS:
			if (t == HTML.Tag.TR)
			{
				stateTo(State.GETTING_DATA_NAME);
			}
			break;
		case LOOKING_FOR_NEXT_DATA_NAME:
			if (t == HTML.Tag.TR)
			{
				stateTo(State.GETTING_DATA_NAME);
			}
			break;
		case LOOKING_FOR_NEXT_TABLE:
			if (t == HTML.Tag.TABLE)
			{
				if ( annual )
				{
					type++;
					//System.err.println("===" + types[type] + "===");
					annual = false;
				}
				else
				{
					annual = true;
				}
				statementPosOffset = statements.size();
				stateTo(State.BEFORE_STATEMENT_HEADERS);
			}
			break;
		}
	}

	public void handleEndTag(HTML.Tag tag, int pos)
	{
		try
		{
			_handleEndTag(tag, pos);
		}
		catch(Throwable t)
		{
			failHard(t);
		}
	}
	
	public void _handleEndTag(HTML.Tag t, int pos)
	{
		//System.err.println("Handle end tag: " + t);
		switch (state)
		{
		case BEFORE_STATEMENT_HEADERS:
			if (t == HTML.Tag.TH)
			{
				stateTo(State.READING_STATEMENT_HEADERS);
			}
			break;
		case READING_STATEMENT_HEADERS:
			if (t == HTML.Tag.TR)
			{
				stateTo(State.FINISHED_STATEMENT_HEADERS);
			}
			break;
		case GETTING_DATA:
			if (t == HTML.Tag.TR)
			{
				stateTo(State.LOOKING_FOR_NEXT_DATA_NAME);
			}
			if (t == HTML.Tag.TABLE)
			{
				stateTo(State.LOOKING_FOR_NEXT_TABLE);
			}
			break;
		case FINISHED_STATEMENT_HEADERS:
		case LOOKING_FOR_NEXT_DATA_NAME:
		case GETTING_DATA_NAME:
			if (t == HTML.Tag.TABLE)
			{
				stateTo(State.LOOKING_FOR_NEXT_TABLE);
			}
			break;
		}
	}

	public void handleText(char[] data, int pos)
	{
		try
		{
			_handleText(data, pos);
		}
		catch(Throwable t)
		{
			failHard(t);
		}
	}
	
	public void _handleText(char[] data, int pos)
	{
		//System.err.println("Handle text: " + new String(data));
		switch (state)
		{
		case READING_STATEMENT_HEADERS:
			ParsedItem newEntry = new ParsedItem();
			newEntry.setDate(new String(data).trim());
			newEntry.setType(types[type]);
			statements.add(newEntry);
			break;
		case GETTING_DATA_NAME:
			//System.err.println("Got data name " + new String(data));
			currentName = new String(data).trim();
			stateTo(State.GETTING_DATA);
			statementPosTo(statementPosOffset);
			break;
		case GETTING_DATA:
			//System.err.println("Got data " + new String(data));
			MethodNames.convertToMethodName(currentName);
			statements.get(statementPos).put(currentName,
					new String(data).trim());
			statementPosTo(statementPos+1);
			break;
		}
	}
	
	public ParsedItems getStatements()
	{
		return statements;
	}
	
	private void failHard(Throwable t)
	{
		t.printStackTrace();
		System.err.println("EXITING VM");
		System.exit(-1);
	}
	
	private void stateTo(State newState)
	{
		//System.err.println("Switch from " + state + " to " + newState);
		state = newState;
	}
	
	private void statementPosTo(int newstatementPos)
	{
		//System.err.println("Statement pos from " + statementPos + " to " + newstatementPos);
		statementPos = newstatementPos;		
	}
}