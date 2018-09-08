package uk.me.suriar.interview;

import java.util.HashMap;
import java.util.Map;

public class LetterNumberSequence
{
    public String find(final String s)
    {
	final Map<Integer,Integer> diffMap = new HashMap<>();
	
	final int[] neededDiffs = new int[s.length()];
	
	int letterCount = 0;
	int numberCount = 0;
	int currDiff = 0;
	
	for (int i = 0; i < s.length(); ++i)
	{
	    neededDiffs[i] = currDiff;
	    
	    if (Character.isDigit(s.charAt(i)))
	    {
		++numberCount;
		--currDiff;
	    }
	    else if (Character.isAlphabetic(s.charAt(i)))
	    {
		++letterCount;
		++currDiff;
	    }
	    else
	    {
		return "";
	    }
	    
	    final Integer diffPos = diffMap.get(currDiff);
	    if (diffPos == null || diffPos < i)
	    {
		diffMap.put(currDiff, i);
		System.out.println(String.format("Adding diff map %s -> %s", currDiff, i));
	    }
	}
	
	if (letterCount == 0 || numberCount == 0) return "";
	
	int seqStart = 0, seqEnd = 0, seqLen = 0;
	
	for (int i = 0; i < s.length(); ++i)
	{
	    final Integer diffPos = diffMap.get(neededDiffs[i]);
	    if (diffPos != null && (diffPos - i) > seqLen)
	    {
		seqStart = i;
		seqEnd = diffPos;
		seqLen = seqEnd - seqStart + 1;
		System.out.println(String.format("Found sequence [%s,%s]", seqStart, seqEnd));
	    }
	    if (seqLen > s.length() - i) break;
	}
	
	return s.substring(seqStart, seqEnd+1);
    }

}
