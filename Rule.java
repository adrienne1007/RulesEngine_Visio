import javafx.util.Pair;

import java.util.Map;


public class Rule {
    private Map<String, Pair<Condition, Condition>> conditionPair;

    public Rule(Map<String, Pair<Condition, Condition>> conditionPair) {
        this.conditionPair = conditionPair;
    }

    public Map<String, Pair<Condition, Condition>> getConditionPair() {
        return conditionPair;
    }

    public void setConditionPair(Map<String, Pair<Condition, Condition>> conditionPair) {
        this.conditionPair = conditionPair;
    }
}

