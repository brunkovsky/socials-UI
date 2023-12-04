package com.example.socials.ui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExecutorScheduler {

    private String schedulerName;
    private boolean enable;
    private int period;
    private Date lastTimeFetched;

}
