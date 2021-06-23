package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("ForumStatistics Test Suite")
public class ForumStatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    public void beforeEveryTest() {
        // default for all tests
        List<String> resultListUsers = generateListOfNUsers(5);
        when(statisticsMock.userNames()).thenReturn(resultListUsers);
        when(statisticsMock.postCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(30);
    }

    @DisplayName(
            "when posts quantity = 0"
    )
    @Test
    void testCalculateAdvStatisticsPostsCount0() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.postCount()).thenReturn(0);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double resultStatPostsPerUser = forumStatistics.getStatPostsPerUser();
        double resultStatCommentsPerUser = forumStatistics.getStatCommentsPerUser();
        double resultStatCommentsPerPost = forumStatistics.getStatCommentsPerPost();

        //Then
        assertEquals(0.0, resultStatPostsPerUser);
        assertEquals(6.0, resultStatCommentsPerUser);
        assertEquals(-1.0, resultStatCommentsPerPost);
    }

    @DisplayName(
            "when posts quantity = 1000"
    )
    @Test
    void testCalculateAdvStatisticsPostsCount1000() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.postCount()).thenReturn(1000);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double resultStatPostsPerUser = forumStatistics.getStatPostsPerUser();
        double resultStatCommentsPerUser = forumStatistics.getStatCommentsPerUser();
        double resultStatCommentsPerPost = forumStatistics.getStatCommentsPerPost();

        //Then
        assertEquals(200.0, resultStatPostsPerUser);
        assertEquals(6.0, resultStatCommentsPerUser);
        assertEquals(0.03, resultStatCommentsPerPost);
    }

    @DisplayName(
            "when comments quantity = 0"
    )
    @Test
    void testCalculateAdvStatisticsCommentsCount0() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double resultStatPostsPerUser = forumStatistics.getStatPostsPerUser();
        double resultStatCommentsPerUser = forumStatistics.getStatCommentsPerUser();
        double resultStatCommentsPerPost = forumStatistics.getStatCommentsPerPost();

        //Then
        assertEquals(2.0, resultStatPostsPerUser);
        assertEquals(0.0, resultStatCommentsPerUser);
        assertEquals(0.0, resultStatCommentsPerPost);
    }

    @DisplayName(
            "when comments quantity > posts quantity"
    )
    @Test
    void testCalculateAdvStatisticsCommentsCountGreaterThanPostsCount() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(12);
        when(statisticsMock.postCount()).thenReturn(10);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double resultStatPostsPerUser = forumStatistics.getStatPostsPerUser();
        double resultStatCommentsPerUser = forumStatistics.getStatCommentsPerUser();
        double resultStatCommentsPerPost = forumStatistics.getStatCommentsPerPost();
        System.out.println(forumStatistics.showStatistics());

        //Then
        assertEquals(2.0, resultStatPostsPerUser);
        assertEquals(2.4, resultStatCommentsPerUser);
        assertEquals(1.2, resultStatCommentsPerPost);
    }

    @DisplayName(
            "when comments quantity < posts quantity"
    )
    @Test
    void testCalculateAdvStatisticsPostsCountGreaterThanCommentsCount() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(8);
        when(statisticsMock.postCount()).thenReturn(10);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double resultStatPostsPerUser = forumStatistics.getStatPostsPerUser();
        double resultStatCommentsPerUser = forumStatistics.getStatCommentsPerUser();
        double resultStatCommentsPerPost = forumStatistics.getStatCommentsPerPost();

        //Then
        assertEquals(2.0, resultStatPostsPerUser);
        assertEquals(1.6, resultStatCommentsPerUser);
        assertEquals(0.8, resultStatCommentsPerPost);
    }

    @DisplayName(
            "when users quantity is 0"
    )
    @Test
    void testCalculateAdvStatisticsUsersCount0() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> resultListUsers = generateListOfNUsers(0);
        when(statisticsMock.userNames()).thenReturn(resultListUsers);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double resultStatPostsPerUser = forumStatistics.getStatPostsPerUser();
        double resultStatCommentsPerUser = forumStatistics.getStatCommentsPerUser();
        double resultStatCommentsPerPost = forumStatistics.getStatCommentsPerPost();

        //Then
        assertEquals(-1.0, resultStatPostsPerUser);
        assertEquals(-1.0, resultStatCommentsPerUser);
        assertEquals(3.0, resultStatCommentsPerPost);
    }

    @DisplayName(
            "when users quantity is 100"
    )
    @Test
    void testCalculateAdvStatisticsUsersCount100() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics();
        List<String> resultListUsers = generateListOfNUsers(100);
        when(statisticsMock.userNames()).thenReturn(resultListUsers);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        double resultStatPostsPerUser = forumStatistics.getStatPostsPerUser();
        double resultStatCommentsPerUser = forumStatistics.getStatCommentsPerUser();
        double resultStatCommentsPerPost = forumStatistics.getStatCommentsPerPost();

        //Then
        assertEquals(0.1, resultStatPostsPerUser);
        assertEquals(0.3, resultStatCommentsPerUser);
        assertEquals(3.0, resultStatCommentsPerPost);
    }

    private List<String> generateListOfNUsers(int usersQuantity) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= usersQuantity; n++) {
            String theUser = "User " + n;
            resultList.add(theUser);
        }
        return resultList;
    }
}
