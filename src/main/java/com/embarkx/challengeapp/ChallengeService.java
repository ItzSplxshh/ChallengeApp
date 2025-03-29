package com.embarkx.challengeapp;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges =
            new ArrayList<>();
    private Long nextid = 1L;
    public ChallengeService(){
    }

    public List<Challenge> getAllChallenges(){
        return challenges;
    }
    public boolean addChallenge(Challenge challenge) {
        if (challenge != null){
            challenge.setId(nextid++);
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }
    }

    public Challenge getChallenge(String month) {
        for (Challenge challenge: challenges) {
            if (challenge.getMonth().equalsIgnoreCase(month)) {
                return challenge;
            }
        }
        return null;
    }
}
