import java.util.Optional;

public class RuleEngineMainApplication {

    public static void main(String[] args) {
        Integer creditScore = 750;

        Person person = new Person(creditScore, "Florida");
        Product product = new Product("7-1 ARM", 5.0, true);
        RuleEngine engine = new RuleEngine();
        engine.loadRules(creditScore);
        Product resultProduct = engine.runRules(person, product, Optional.empty());
        System.out.println(resultProduct.toString());

    }
}

