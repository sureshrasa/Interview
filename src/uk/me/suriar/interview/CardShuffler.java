package uk.me.suriar.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardShuffler
{

    public List<Integer> shuffle(final int totalCards)
    {
	final int[] cards = generateCards(totalCards);
	shuffle(cards, totalCards);
	return Arrays.stream(cards).boxed().collect(Collectors.toList());
    }

    private void shuffle(final int[] cards, final int totalCards)
    {
	if (totalCards == 1)
	    return;

	shuffle(cards, totalCards - 1);
	swap(cards, random(totalCards), totalCards - 1);
    }

    private void swap(final int[] cards, final int i, final int j)
    {
	final int temp = cards[i];
	cards[i] = cards[j];
	cards[j] = temp;
    }

    private int random(final int i)
    {
	return (int) (Math.random() * (i - 1));
    }

    private int[] generateCards(int totalCards)
    {
	final int[] cards = new int[totalCards];

	for (int i = 0; i < totalCards; ++i)
	{
	    cards[i] = i;
	}

	return cards;
    }
}
