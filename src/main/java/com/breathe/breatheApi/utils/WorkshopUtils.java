package com.breathe.breatheApi.utils;

import com.breathe.breatheApi.core.Workshop;
import com.breathe.breatheApi.enums.Location;
import com.breathe.breatheApi.enums.WorkshopType;
import com.breathe.breatheApi.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkshopUtils {
    @Autowired
    private WorkshopRepository workshopRepository;

    public static List<Workshop> generateWorkshops() {
        List<Workshop> workshops = new ArrayList<>();

        Workshop clothingSwap = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 11, 8, 0, 0))
                .endTime(LocalDateTime.of(2018, 7, 11, 17, 0, 0))
                .title("Clothing Swap")
                .description("Drop off day on the first day of the festival. Every day following, the tent will be open for anyone to pick. Donation binswill be available and clearly marked for those who can't donate on the first day. This will be setup the entire festival.WHAT: Free clothes for all! No money/currency will be exchanged. Love each other and our precious Gaia, MotherEarth. Give clothes or take clothes. As many as you want or need. If you donate, donate clothes that are still good to wear. All styles, all kinds, cold weather, warm weather, water, snow, deep space, anything is welcome except underwear/socks, just to be safe (unless the underwear/socks have never been worn). Hangers are welcome too. WHY: We are doing a clothing swap because it's an easy way to show love to one another by sharing abundance,giving and receiving gifts, and helping our planet suffer less. There's an overabundance of clothes on our planet. Buying clothes new or from big stores not only supports large multinational companies who hire underpaid workers in the poorest conditions, but also unnecessarily exerts our nurturing Gaia (our living planet) during production and shipping. Some of us have a closet full of clothes that go unworn while some of us have only a tattered shirt. Give your surplus. Kindly take what you need or want, and don't hesitate to bring/take a lot, this is by you and for you")
                .type(WorkshopType.OTHER)
                .location(Location.CLOTHING_SWAP)
                .build();

        Workshop musicPerformance = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 11, 16, 30, 0))
                .endTime(LocalDateTime.of(2018, 7, 11, 17, 30, 0))
                .title("Intro to Music, Music Performance, and Music Tech")
                .description("This class will cover a basic introduction to all things music and music performance. You'll receive a basic introductionto music theory, basic sound gear set-up for amplified performances with hands on learning, professional stage presence techniques, and finish with a question session for all aspiring musicians, performers, or sound technicians.This workshop is led by Veronika Nelson, Breathe's Music Harmony Director. Her experience includes studyingMusical Theatre at the conservatory level, performing Off-Broadway, and working with professional bands in NYC,Denver, and internationally. Veronika has taught in professional spaces all over the United States")
                .type(WorkshopType.TALKS)
                .location(Location.ENSOUL_MUSIC_BARN)
                .build();

        Workshop fireSafety = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 11, 18, 0, 0))
                .endTime(LocalDateTime.of(2018, 7, 11, 19, 0, 0))
                .title("Fire Safety Meeting")
                .description("The Fire Safety Meeting is a requirement for all breathers who would like to spin fire and/or volunteer for the firecircle on any given night of the festival. There will be one meeting each evening to ensure everyone has an opportunity to attend. You WILL NOT be allowed to spin fire or volunteer without taking the safety course. NO EXCEPTIONS, thank you! During this meeting we will cover all of the fire safety rules and Breathe procedures in place to keep performers, volunteers, and spectators safe. Attendees will be given a crash course regarding regarding how to dress fire-safe, prop maintenance, our fuel depot and circle protocol, active safety, spinning fire, how to safely extinguish props, and emergency situations. Once completed, breathers will be given a wrist band to prove they have taken the course. You must wear your wristband to the circle at night in order to spin. We look forward to cultivating a safe space for fire artists to play and entertain at Breathe.")
                .type(WorkshopType.FLOW_ARTS)
                .location(Location.THE_COURT)
                .build();

        Workshop learn = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 12, 8, 0, 0))
                .endTime(LocalDateTime.of(2018, 7, 12, 9, 0, 0))
                .title("Learn to Slackline")
                .description("Have you ever been interested in slacklining, and the wonderful community who is doing it? Then this is the perfect class for you. We will talk about the basic skills on a slackline. You will not just learn how to find your balance and to have fun at the same time, but also how to stand and walk on a line. Come out and play!")
                .type(WorkshopType.SLACKLINING)
                .location(Location.LOWLINE_SLACKLINE_PARK)
                .build();

        Workshop inversions = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 12, 8, 0, 0))
                .endTime(LocalDateTime.of(2018, 7, 12, 9, 0, 0))
                .title("Slackline Inversions: Using your Legs like Arms")
                .description("Are you looking for new ways to play on a slackline? Have you ever considered, maybe, using your legs like arms? Slackline supported inversions are rad way to have fun on a line and find a new perspective. In this short workshop, we'll explore playful ways to get upside-down on a slackline, building the basics towards a hands-free shoulder stand.All levels welcome!")
                .type(WorkshopType.SLACKLINING)
                .location(Location.PEAK_TO_PEAK_SLACKLINE_PARK)
                .build();

        Workshop acro = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 12, 8, 0, 0))
                .endTime(LocalDateTime.of(2018, 7, 12, 9, 0, 0))
                .title("So You Think You Can't Acro? The Basics!")
                .description("Acro is so much fun, just knowing a few moves can help you relax, meet new folks, build strength, and get comfy in your body. This workshop will be an intro to Acro yoga. Moving through prep work, leaning the basics, and doing a little flying! If you are new to basing or flying this is the class for you! If you want a re-fresh or have flown but would like to base - join us! It's going to be fun! Sophia and Josh have been doing Acro yoga for a little over a year. Sophia is a RYT 200hr and has been teaching yoga for over 10 years. In Acro they both found a new way to connect to self,others, and increase strength and relaxation. Come join the fun of Acro! Please bring a yoga mat or blanket.")
                .type(WorkshopType.ACRO_YOGA)
                .location(Location.MOVEMENT_TENT)
                .build();

        Workshop fireShow = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 13, 21, 45, 0))
                .endTime(LocalDateTime.of(2018, 7, 13, 22, 15, 0))
                .title("Fire In The Sky")
                .description("Shaun Perrill will light up the sky in a display sure to make you smile and realize the beauty of what it means to be human")
                .type(WorkshopType.BREATHE_EVENT)
                .location(Location.IDIOPAN_STAGE)
                .build();

        Workshop howl = Workshop.builder()
                .startTime(LocalDateTime.of(2018, 7, 13, 22, 0, 0))
                .endTime(LocalDateTime.of(2018, 7, 14, 0, 0, 0))
                .title("HOWL: Full Moon Circle")
                .description("Burn. Release. Howl. Dance. You'll be guided in a meditation, share what arises, and create an intention for what you'd like to release. We'll allow the fire to burn what no longer serves us and spark our wild spirit. We'll howl to our heart's content. We'll allow the dance to express a full body release of stagnant energy, open ourselves to what's to come, and celebrate the journey! May you leave feeling FREE and WILD")
                .type(WorkshopType.HEALING)
                .location(Location.FIRE_PIT)
                .build();

        workshops.add(clothingSwap);
        workshops.add(musicPerformance);
        workshops.add(fireSafety);
        workshops.add(learn);
        workshops.add(inversions);
        workshops.add(acro);
        workshops.add(fireShow);
        workshops.add(howl);
        return workshops;
    }
}
