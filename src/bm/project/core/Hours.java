package bm.project.core;

import java.time.LocalTime;

public class Hours {
    public LocalTime Open;
    public LocalTime End;
    public boolean OpenState;

    public Hours(String open, String end){
        this.Open = LocalTime.parse(open);
        this.End = LocalTime.parse(end);
        LocalTime now = LocalTime.now();
        boolean OpenState = now.isAfter(End); //지금이 닫은시간 기준으로 지났는지
    }
}
