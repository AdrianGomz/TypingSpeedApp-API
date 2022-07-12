package com.example.api.quote;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuoteConfig {
        @Bean
        CommandLineRunner commandLineRuner(QuoteRepository quoteRepository) {
                return args -> {
                        Quote quote1 = new Quote(
                                        1L, "Speak yourself ",
                                        "So, let's all take one more step. We have learned to love ourselves, so now I urge you to \"speak yourself.\" I would like to ask all of you. What is your name? What excites you and makes your heart beat? Tell me your story. I want to hear your voice, and I want to hear your conviction. No matter who you are, where you're from, your skin colour, gender identity: speak yourself.",
                                        "Kim Namjoon", LocalDate.of(2022, Month.JULY, 11));

                        Quote quote2 = new Quote(
                                        2L, "Bungou Stray Dogs",
                                        "Everyone fights, searching for the correct way to live their life. What do they seek by fighting? How ought they live? No one can say. All we have has the right to waver, like stray dogs that have hit rock bottom.",
                                        "Osamu Dazai",
                                        LocalDate.of(2022, Month.JULY, 11));

                        Quote quote9 = new Quote(
                                        9L, "Peter Montgomery",
                                        "The world is not divided into good people and bad people. No matter what we like to tell ourselves, every one of us can and will do good or bad things every day. You can stick up for a friend with the utmost integrity, and then go to work and do something that compromises your values. You can spend all day making your community a better place, and then come home and hurt somebody you love. We are not all good or all bad.",
                                        "Anonymous",
                                        LocalDate.of(2022, Month.JULY, 11));

                        Quote quote3 = new Quote(
                                        3L, "Peace in Ireland",
                                        "There can never be peace in Ireland until the foreign oppressive British presence is removed, leaving all the Irish people as a unit to control their own affairs and determine their own destinies as a sovereign people, free in mind and body, separate and distinct physically, culturally, and economically.",
                                        "Bobby Sands",
                                        LocalDate.of(2022, Month.JULY, 11));

                        Quote quote4 = new Quote(
                                        4L, "Leon: The Professional",
                                        "I like these calm little moments before the storm. It reminds me of Beethoven. Can you hear it? It's like when you put your head to the grass and you can hear the growin' and you can hear the insects. Do you like Beethoven?",
                                        "Stansfield",
                                        LocalDate.of(2022, Month.JULY, 11));

                        Quote quote5 = new Quote(
                                        5L, "High Speed Test",
                                        "For those of you who want to have a Quote quote = new high score for this test, this text is the one that will get you a Quote quote = new high score. The only thing you have to do is type fast without errors.",
                                        "Anonymous",
                                        LocalDate.of(2022, Month.JULY, 11));

                        Quote quote6 = new Quote(
                                        6L, "Emotions",
                                        "Emotions can be hard to control sometimes. If you don't control them they end up controlling you. If you let your mind wander it may lead you to thoughts that stir up your emotional state. Don't let others affect you or your emotional state. Stay focused, be strong, and decide for yourself what your emotions should be.",
                                        "Thinking Dreamer",
                                        LocalDate.of(2022, Month.JULY, 11));

                        Quote quote7 = new Quote(
                                        7L, "Easy Quote ",
                                        "I hate the hard and long quotes. So, this one should be fairly easy to type. While making this for you, I didn't make any mistakes! Have fun with this one and enjoy your break!",
                                        "lonelycrier2.0",
                                        LocalDate.of(2022, Month.JULY, 11));
                        Quote quote8 = new Quote(
                                        8L, "Snow Crash - Chapter 1",
                                        "The Deliverator belongs to an elite order, a hallowed subcategory. He's got esprit up to here. Right now, he is preparing to carry out his third mission of the night. His uniform is black as activated charcoal, filtering the very light out of the air. A bullet will bounce off its arachnofiber weave like a wren hitting a patio door, but excess perspiration wafts through it like a breeze through a freshly napalmed forest.",
                                        "Neal Stephenson",
                                        LocalDate.of(2022, Month.JULY, 11));
                        quoteRepository.saveAll(Arrays.asList(quote1, quote2, quote3, quote4, quote5, quote6, quote7,
                                        quote8, quote9));

                };
        }
}