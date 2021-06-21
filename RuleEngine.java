import javafx.util.Pair;

import java.util.*;

public class RuleEngine {

    private Rule rules;

    public void loadRules(Integer creditScore) {
        Map<String, Pair<Condition, Condition>> conditionMap = new HashMap<>();

        conditionMap.put("state", new Pair(new Condition("state", Optional.of(Operator.EQUAL), Optional.empty(), "Florida"), new Condition("offering", Optional.empty(), Optional.of(Action.DISQUALIFY), "")));

        if (creditScore >= 720) {
            conditionMap.put("creditScore", new Pair(new Condition("creditScore", Optional.of(Operator.GREATER), Optional.empty(), "720"), new Condition("interestRate", Optional.empty(), Optional.of(Action.DECREASE_BY_X), "0.3")));
        } else {
            conditionMap.put("creditScore", new Pair(new Condition("creditScore", Optional.of(Operator.LESSER), Optional.empty(), "720"), new Condition("interestRate", Optional.empty(), Optional.of(Action.INCREASE_BY_X), "0.5")));
        }
        conditionMap.put("name", new Pair(new Condition("name", Optional.of(Operator.EQUAL), Optional.empty(), "7-1 ARM"), new Condition("interestRate", Optional.empty(), Optional.of(Action.INCREASE_BY_X), "0.5")));

        rules = new Rule(conditionMap);
    }

    public Product runRules(Person person, Product product, Optional<Rule> userRules) {
        return evaluateRule(person, product, aggregateRules(this.rules, userRules));
    }

    private Product evaluateRule(Person person, Product product, Rule customRule) {
        Map<String, Pair<Condition, Condition>> globalRules = customRule.getConditionPair();
        boolean disqualified = product.getDisqualified();
        double interestRate = product.getInterestRate();
        String name = product.getName();
        if (globalRules.containsKey("state")) {
            if (globalRules.get("state").getKey().getSubject() != person.getState()) {
                disqualified = globalRules.get("state").getValue().getAction().get() != Action.DISQUALIFY;
            }
        }
        if (globalRules.containsKey("creditScore")) {
            if (globalRules.get("creditScore").getKey().getOperator().get() == Operator.GREATER) {
                interestRate = interestRate - 0.3;
            } else {
                interestRate = interestRate + 0.5;
            }
        }
        if (globalRules.containsKey("name")) {
            if (globalRules.get("name").getKey().getSubject() == product.getName()) {
                interestRate = interestRate + Double.parseDouble(globalRules.get("name").getValue().getSubject());
            }
        }
        Product customProduct = new Product(name, interestRate, disqualified);

        return customProduct;
    }

    private Rule aggregateRules(Rule globalRule, Optional<Rule> userRule) {
        Map<String, Pair<Condition, Condition>> conditionMap = new HashMap<>();
        conditionMap.putAll(globalRule.getConditionPair());
        if (userRule.isPresent()) {
            conditionMap.putAll(userRule.get().getConditionPair());
        }
        return new Rule(conditionMap);
    }
}

