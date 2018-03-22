package com.cs371_HCI.nowServingQueue.entity;

import java.time.Duration;
import java.time.Instant;

public class Student {
    private int id;
    private String name;
    private String course;
//    private Instant startTime;
    private Boolean receivedHelp;
    //    private long timeOnQueue;

    public Student() {}

    public Student(int id, String name, String course, Boolean receivedHelp) {
        this.id = id;
        this.name = name;
        this.course = course;
//        this.startTime = Instant.now();

        if (!receivedHelp) {
            this.receivedHelp = false;
        } else {
            this.receivedHelp = receivedHelp;
        }


//        this.timeOnQueue = 1;
       // setTimeOnQueue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

//    public Instant getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(Instant currentTime) {
//        this.startTime = currentTime;
//    }

    public Boolean getReceivedHelp() {
        return receivedHelp;
    }

    public void setReceivedHelp(Boolean receivedHelp) {
        if (receivedHelp != null) {
            this.receivedHelp = receivedHelp;
        } else {
            this.receivedHelp = false;
        }
    }
//
//    public long getTimeOnQueue() {
//        return timeOnQueue;
//    }
//
//    public void setTimeOnQueue() {
//
//
////        Instant currentTime = Instant.now();
////        Duration elapsedTime = Duration.between(this.startTime, currentTime);
////
////        this.timeOnQueue = elapsedTime.toMinutes();
////        System.out.println("Time on queue = " + this.timeOnQueue);
//    }
}
