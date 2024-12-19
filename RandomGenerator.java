public class RandomGenerator implements Comparable<RandomGenerator>{
    int lowerBound;
    int upperBound;
    public RandomGenerator(int lowerBound, int upperBound){
        if(lowerBound >= upperBound){
            throw new RuntimeException("Lower bound cannot be greater than upper bound.");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    int nextRandom(){
        return (int)(Math.random() * (upperBound - lowerBound) + lowerBound);
    }
    @Override
    public int compareTo(RandomGenerator o) {
        if((lowerBound == o.lowerBound) && (upperBound == o.upperBound)){
            return 0;
        }else if((lowerBound<o.lowerBound) && (upperBound<o.upperBound)){
            return 99;
        }else if((lowerBound > o.lowerBound)&& (upperBound<=o.upperBound)){
            return -1;
    }else{
        return 1;
    }
}
}