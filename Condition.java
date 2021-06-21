import java.util.Optional;

public class Condition {

    private String predicate;

    private Optional<Operator> operator;

    private Optional<Action> action;

    private String subject;

    public Condition(String predicate, Optional<Operator> operator, Optional<Action> action, String subject) {
        this.predicate = predicate;
        this.operator = operator;
        this.action = action;
        this.subject = subject;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public Optional<Operator> getOperator() {
        return operator;
    }

    public void setOperator(Optional<Operator> operator) {
        this.operator = operator;
    }

    public Optional<Action> getAction() {
        return action;
    }

    public void setAction(Optional<Action> action) {
        this.action = action;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
