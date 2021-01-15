package edu.ecnu.sei.MeetHere;

public enum Site {

    gymb1("体育馆1号篮球场地"),
    gymb2("体育馆2号篮球场地"),
    gymbad1("体育馆1号羽毛球场地"),
    gymbad2("体育馆2号羽毛球场地"),
    libroom1("图书馆1号教室"),
    libroom2("图书馆2号教室"),
    meetingroom1("1号会议室"),
    meetingroom2("2号会议室");


    private String name;

    Site(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
