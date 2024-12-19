public class RestrictedRandomGenerator extends RandomGenerator{
    public RestrictedRandomGenerator(int lowerBound,int upperBound){
        super(lowerBound, upperBound);
    }
    public int nextRestrictedRandom(int restrictedNumber){
        int num = nextRandom();
        while(num == restrictedNumber){
            num = nextRandom();
        }
        return num;
    }
}