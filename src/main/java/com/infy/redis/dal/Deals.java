package com.infy.redis.dal;

import lombok.Data;

@Data
public class Deals {
    private int appreciationGivenCoins;
    private int appreciationReceivedCoins;
    private int feedbackGivenCoins;
    private int feedbackReceivedCoins;  
    private int courseCompleteCoins;
    private int taskCompleteCoins;

}
