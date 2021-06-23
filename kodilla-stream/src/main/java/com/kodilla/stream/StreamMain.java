package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        LocalDate testDate = LocalDate.now().minusYears(20);

        ForumUser forumUser1 = new ForumUser(1, "Kowalski", 'M',
                LocalDate.parse("1974-01-08"), 100 );
        ForumUser forumUser2 = new ForumUser(2, "Nowak", 'F',
                LocalDate.parse("1994-01-08"), 10 );
        ForumUser forumUser3 = new ForumUser(3, "Iksinski", 'M',
                LocalDate.parse("2002-01-08"), 50 );
        ForumUser forumUser4 = new ForumUser(4, "Zawada", 'M',
                LocalDate.parse("1984-01-08"), 0 );
        ForumUser forumUser5 = new ForumUser(5, "Marszalek", 'M',
                LocalDate.parse("1998-01-08"), 1 );

        List<ForumUser> forumUserList = new ArrayList<>();
        forumUserList.add(forumUser1);
        forumUserList.add(forumUser2);
        forumUserList.add(forumUser3);
        forumUserList.add(forumUser4);
        forumUserList.add(forumUser5);

        Forum forum = new Forum(forumUserList);

        Map<Integer, ForumUser> theResultMapOfUsers = forum.getUserList().stream()
                .filter(u -> u.getUserSex() == 'M')
                .filter(u -> u.getBirthDate().isBefore(testDate))
                .filter(u -> u.getPostsCount() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


/*        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify("tekst", s -> "ABC" + s + "ABC"));
        System.out.println(poemBeautifier.beautify("tekst", s -> s.toUpperCase()));
        System.out.println(poemBeautifier.beautify("tekst", s -> s + "_" +s.substring(2,4)));
        System.out.println(poemBeautifier.beautify("tekst", s -> {
            String tmp = "";
            final String separator = "_";
            tmp = s.substring(2,4);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tmp);
            stringBuilder.append(separator);
            stringBuilder.append(s);
            stringBuilder.append(separator);
            stringBuilder.append(tmp);
            return stringBuilder.toString();
        }));*/

    }
}
