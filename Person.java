public class Person {

    public Person(Integer creditScore, String state) {
        this.creditScore = creditScore;
        this.state = state;
    }

    private Integer creditScore;

    private String state;


    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Person{" +
                "creditScore=" + creditScore +
                ", state='" + state + '\'' +
                '}';
    }
}
