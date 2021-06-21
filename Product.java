public class Product {

    private String name;

    private Double interestRate;

    private Boolean disqualified;

    public Product(String name, Double interestRate, Boolean disqualified) {
        this.name = name;
        this.interestRate = interestRate;
        this.disqualified = disqualified;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", interestRate=" + interestRate +
                ", disqualified=" + disqualified +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Boolean getDisqualified() {
        return disqualified;
    }

    public void setDisqualified(Boolean disqualified) {
        this.disqualified = disqualified;
    }
}
