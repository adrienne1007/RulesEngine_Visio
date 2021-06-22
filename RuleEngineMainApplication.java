
import java.util.Optional;

public class RuleEngineMainApplication {

    public static void main(String[] args) {
        Integer creditScore = 750;
        final Integer baseCreditScore = 720;

        Person person = new Person(creditScore, "Florida");
        Product product = new Product("7-1 ARM", 5.0, true);
        RuleEngine engine = new RuleEngine();
        engine.loadRules(creditScore, baseCreditScore);

//        Adding custom rule. In this instance. If State == Georgia, product is disqualified
//        Map<String, Pair<Condition, Condition>> newRule = new HashMap<>();
//        newRule.put("state", new Pair(new Condition("state", Optional.of(Operator.EQUAL), Optional.empty(), "Georgia"), new Condition("offering", Optional.empty(), Optional.of(Action.DISQUALIFY), "")));
//        Rule customRules = new Rule(newRule);
//
//        Product resultProduct = engine.runRules(person, product, Optional.of( customRules ));

        Product resultProduct = engine.runRules(person, product, Optional.empty());
        System.out.println(resultProduct.toString());

    }
}

