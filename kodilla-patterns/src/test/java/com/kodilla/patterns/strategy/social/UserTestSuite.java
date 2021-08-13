package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("Jan Kowalski");
        User user2 = new YGeneration("Zygfryd Lewandowski");
        User user3 = new ZGeneration("Ambroży Nowak");

        //When
        String janPublishes = user1.sharePost();
        System.out.println("Jan chose -> " + janPublishes);
        String zygfrydPublishes = user2.sharePost();
        System.out.println("Zygfryd chose -> " + zygfrydPublishes);
        String ambrozyPublishes = user3.sharePost();
        System.out.println("Ambroży chose -> " + ambrozyPublishes);

        //Then
        assertEquals("Social media: Facebook", janPublishes);
        assertEquals("Social media: Twitter", zygfrydPublishes);
        assertEquals("Social media: Snapchat", ambrozyPublishes);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user1 = new Millenials("Jan Kowalski");

        //When
        String janPublishes = user1.sharePost();
        System.out.println("Jan chose -> " + janPublishes);
        user1.setSocialPublisher(new SnapchatPublisher());
        janPublishes = user1.sharePost();
        System.out.println("Jan chose -> " + janPublishes);
        
        //Then
        assertEquals("Social media: Snapchat", janPublishes);
    }
}
