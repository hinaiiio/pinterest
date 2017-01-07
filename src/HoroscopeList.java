import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.tools.javac.util.List;


/**
 * Created by hina on 2017/01/05.
 */
public class HoroscopeList {
    private Horoscopes horoscope;

    @JsonCreator
    public HoroscopeList(@JsonProperty("horoscope")Horoscopes horoscope) {
        System.out.println("@JsonCreator が付いてるコンストラクタが呼ばれたよ！！");
        this.horoscope = horoscope;
    }

    public HoroscopeList(){

    }

    public Horoscopes getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(Horoscopes horoscope) {
        this.horoscope = horoscope;
    }

    public class Horoscopes{

        @JsonProperty("2017/01/01")
        private List<Horoscope> date;

        @JsonCreator
        public Horoscopes(@JsonProperty("2017/01/01") List<Horoscope> date) {
            this.date = date;
        }


        @JsonProperty("2017/01/01")
        public List<Horoscope> getDate() {
            return date;
        }

        public void setDate(List<Horoscope> date) {
            this.date = date;
        }

    }

    public class Horoscope {
        private String content;
        private String item;
        private int money;
        private int total;
        private int job;
        private String color;
        private int love;
        private int rank;
        private String sign;

        public Horoscope(
                @JsonProperty("content") String content,
                @JsonProperty("item") String item,
                @JsonProperty("money") int money,
                @JsonProperty("total") int total,
                @JsonProperty("job") int job,
                @JsonProperty("color") String color,
                @JsonProperty("love") int love,
                @JsonProperty("rank") int rank,
                @JsonProperty("sign") String sign) {
            this.content = content;
            this.item = item;
            this.money = money;
            this.total = total;
            this.job = job;
            this.color = color;
            this.love = love;
            this.rank = rank;
            this.sign = sign;
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


