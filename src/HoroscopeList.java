import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hina on 2017/01/05.
 */
public class HoroscopeList {
    private Date horoscope;

    public HoroscopeList() {
    }

    public Date getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(Date horoscope) {
        this.horoscope = horoscope;
    }

    static public class Date{
        private java.util.List<Horoscope> dayInfo = new ArrayList<Horoscope>();

        public Date(/*@JsonProperty(dayInfo)*/ java.util.List<Horoscope> dayInfo) {
            this.dayInfo = dayInfo;
        }

        public Date() {
        }

        public List<Horoscope> getDayInfo() {
            return dayInfo;
        }

        public void setDayInfo(List<Horoscope> dayInfo) {
            this.dayInfo = dayInfo;
        }
    }

    static public class Horoscope {
        private String content;
        private String item;
        private int money;
        private int total;
        private int job;
        private String color;
        private int day;
        private int love;
        private int rank;
        private String sign;

        public Horoscope() {
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getJob() {
            return job;
        }

        public void setJob(int job) {
            this.job = job;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getLove() {
            return love;
        }

        public void setLove(int love) {
            this.love = love;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

    }
}


