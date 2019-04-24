package com.example.abhirami.rollcaller;

public class StudentDetails {


    private String name;
    private String phoneNo;
    private String rollNo;
    private String voiceID;
    private Room room;

    public StudentDetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getVoiceID() {
        return voiceID;
    }

    public void setVoiceID(String voiceID) {
        this.voiceID = voiceID;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
