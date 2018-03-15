package com.acacias.altfc;


public class Score {

    private Long firsthome;
    private Long firstvisit;
    private Long reshome;
    private Long resvisit;
    private Long sevhome;
    private Long sevvisit;
    private Long fifhome;
    private Long fifvisit;
    private Long fourhome;
    private Long fourvisit;


    // Default constructor required by Firebase
    public Score() {

    }

    //Constructor
    public Score(Long firsthome, Long firstvisit, Long reshome, Long resvisit, Long sevhome, Long sevvisit,
                 Long fifhome, Long fifvisit, Long fourhome, Long fourvisit) {
        this.firsthome = firsthome;
        this.firstvisit = firstvisit;
        this.reshome = reshome;
        this.resvisit = resvisit;
        this.sevhome = sevhome;
        this.sevvisit = sevvisit;
        this.fifhome = fifhome;
        this.fifvisit = fifvisit;
        this.fourhome = fourhome;
        this.fourvisit = fourvisit;

    }

    //Getters
    public Long getFirsthome() {
        return firsthome;
    }

    public Long getFirstvisit() {
        return firstvisit;
    }

    public Long getReshome() {
        return reshome;
    }

    public Long getResvisit() {
        return resvisit;
    }

    public Long getSevhome() {
        return sevhome;
    }

    public Long getSevvisit() {
        return sevvisit;
    }

    public Long getFifhome() {
        return fifhome;
    }

    public Long getFifvisit() {
        return fifvisit;
    }

    public Long getFourhome() {
        return fourhome;
    }

    public Long getFourvisit() {
        return fourvisit;
    }

    //Setters
    public void setFirsthome(Long firsthome) {
        this.firsthome = firsthome;
    }

    public void setFirstvisit(Long firstvisit) {
        this.firstvisit = firstvisit;
    }

    public void setReshome(Long reshome) {
        this.reshome = reshome;
    }

    public void setResvisit(Long resvisit) {
        this.resvisit = resvisit;
    }

    public void setSevhome(Long sevhome) {
        this.sevhome = sevhome;
    }

    public void setSevvisit(Long sevvisit) {
        this.sevvisit = sevvisit;
    }

    public void setFifhome(Long fifhome) {
        this.fifhome = fifhome;
    }

    public void setFifvisit(Long fifvisit) {
        this.fifvisit = fifvisit;
    }

    public void setFourhome(Long fourhome) {
        this.fourhome = fourhome;
    }

    public void setFourvisit(Long fourvisit) {
        this.fourvisit = fourvisit;
    }

}