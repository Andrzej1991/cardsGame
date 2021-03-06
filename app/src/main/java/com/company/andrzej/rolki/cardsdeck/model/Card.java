package com.company.andrzej.rolki.cardsdeck.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Andrzej on 2017-04-28.
 */

public final class Card implements Comparator<Card> {

    @SerializedName("image")
    final String image = null;
    @SerializedName("value")
    @JsonAdapter(RankTypeAdapter.class)
    final int rank = 0;
    @SerializedName("suit")
    final Suit suit = null;
    @SerializedName("code")
    final String code = null;

    public String getImage() {
        return image;
    }

    public int getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int compare(Card o1, Card o2) {
        return Integer.compare(o1.getRank(), o2.getRank());
    }

    public boolean isLesser(Card other) {
        return compare(this, other) > 0;
    }

    public boolean isBigger(Card other) {
        return compare(this, other) < 0;
    }
}

enum Suit {
    @SerializedName("SPADES")SPADES,
    @SerializedName("HEARTS")HEARTS,
    @SerializedName("DIAMONDS")DIAMONDS,
    @SerializedName("CLUBS")CLUBS
}

final class RankTypeAdapter
        extends TypeAdapter<Integer> {

    private static final List<String> ranks = asList("ACE", "2", "3", "4", "5", "6", "7", "8",
            "9", "10", "JACK", "QUEEN", "KING");

    private RankTypeAdapter() {
    }

    @Override
    public void write(final JsonWriter out, final Integer value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer read(final JsonReader in)
            throws IOException {
        final String rank = in.nextString();
        final int index = ranks.indexOf(rank);
        if (index == -1) {
            throw new MalformedJsonException("Cannot parse: " + rank + " at " + in);
        }
        return index + 1;
    }
}
