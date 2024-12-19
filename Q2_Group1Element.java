import java.util.HashMap;

public class Q2_Group1Element extends Q2_Element{
    static HashMap<String,String> reactions;
    public Q2_Group1Element(String name, int protons, int neutrons[]){
        super(name, protons,neutrons);
    }
    public String react(String reactant) throws Q2_UndefinedReactionException {
        String reaction = reactions.get(reactant);
        if (reaction != null) {
            return this.getName() + " " + reaction;
        } else {
            throw new Q2_UndefinedReactionException("Reaction with "+reactant+" is not defined");
        }
    }
}



