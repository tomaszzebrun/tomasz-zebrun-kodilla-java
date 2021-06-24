package com.kodilla.stream.world;

import com.kodilla.stream.portfolio.Board;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        World world = prepareTestData();

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("60000000");
        assertEquals(expectedPeopleQuantity, result);
    }

    private World prepareTestData() {
        Country country1 = new Country(new BigDecimal("10000000"));
        Country country2 = new Country(new BigDecimal("10000000"));
        Country country3 = new Country(new BigDecimal("10000000"));
        Country country4 = new Country(new BigDecimal("10000000"));
        Country country5 = new Country(new BigDecimal("10000000"));
        Country country6 = new Country(new BigDecimal("10000000"));

        Continent continent1 = new Continent();
        continent1.countries.add(country1);
        continent1.countries.add(country2);
        continent1.countries.add(country4);

        Continent continent2 = new Continent();
        continent2.countries.add(country3);
        continent2.countries.add(country5);

        Continent continent3 = new Continent();
        continent3.countries.add(country6);

        World world = new World();
        world.countinents.add(continent1);
        world.countinents.add(continent2);
        world.countinents.add(continent3);

        return world;
    }
}
