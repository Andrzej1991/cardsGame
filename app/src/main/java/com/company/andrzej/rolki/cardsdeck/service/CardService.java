package com.company.andrzej.rolki.cardsdeck.service;


import com.company.andrzej.rolki.cardsdeck.model.Card;
import com.company.andrzej.rolki.cardsdeck.model.CardsArray;
import com.company.andrzej.rolki.cardsdeck.model.Deck;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Andrzej on 2017-04-28.
 */

public class CardService {
    public interface CardAPI {

        //GET NEW DECK
        @GET("new/shuffle")
        Observable<Deck> fetchDeck(@Query("deck_count") int deck_count);

        //GET CARD
        @GET("{deck_id}/draw")
        Observable<Card> fetchCardFromDeckID(@Path("deck_id") String deck_id,
                                             @Query("count") int count);

        //GET CARDS
        @GET("{deck_id}/draw")
        Observable<CardsArray> fetchCardsFromDeckID(@Path("deck_id") String deck_id,
                                                    @Query("count") int count);

        //SHUFFLEDECK
        @GET("{deck_id}/shuffle")
        Observable<Deck> shuffleDeck(@Path("deck_id") String deck_id);
    }
}
