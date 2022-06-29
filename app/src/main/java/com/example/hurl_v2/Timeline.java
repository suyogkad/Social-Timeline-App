package com.example.hurl_v2;

public class Timeline {

    //declaring private variables
    private String postid;
    private String postusername;
    private String postcontent;
    private String postdate;

    public Timeline(String postusername, String postcontent, String postdate) {
        this.postusername = postusername;
        this.postcontent = postcontent;
        this.postdate = postdate;
    }

    public String getPostid() { //gets the post id
        return postid;
    }

    public void setPostid(String postid) { //sets the post id
        this.postid = postid;
    }

    public String getPostusername() {
        return postusername;
    } //gets username for the post

    public void setPostusername(String postusername) {
        this.postusername = postusername;
    }  //sets username in the post

    public String getPostcontent() {
        return postcontent;
    } //gets post description

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    } //sets post description

    public String getPostdate() {
        return postdate;
    } // get when the post is created

    //will set posted date
    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }
}
