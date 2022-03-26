package com.company;

public class Combined {
    private String name;
    private String party;
    private String state;
    private String constituency;
    private String profile;
    private String address;
    private String phone;
    private String fax;
    private String type ;
    private  String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Combined(String name, String party, String state, String constituency, String profile, String address, String phone, String fax,String type,String country) {
        this.name = name;
        this.party = party;
        this.state = state;
        this.constituency = constituency;
        this.profile = profile;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.type = type;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Combined{" +
                "Name ='" + name + '\'' +
                ", Party ='" + party + '\'' +
                ", State ='" + state + '\'' +
                ", Constituency ='" + constituency + '\'' +
                ", Profile ='" + profile + '\'' +
                ", Address ='" + address + '\'' +
                ", Phone ='" + phone + '\'' +
                ", Fax ='" + fax + '\'' +
                ", Type ='" + type + '\'' +
                ", Country ='" + country + '\'' +
                '}';
    }
}
