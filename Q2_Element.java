public class Q2_Element implements Comparable<Q2_Element>{
    private String name;
    private int protons;
    private int neutrons[];

    public Q2_Element(String name, int protons, int neutrons[]){
        if(protons<1 || protons>118){
            throw new RuntimeException("Invalid attributes");
        }
        for(int i=0;i<neutrons.length;i++){
            if(neutrons[i]<0){
                throw new RuntimeException("Invalid attributes");
            }
        }
        this.name = name;
        this.protons = protons;
        for(int i=0;i<neutrons.length;i++){
            this.neutrons[i] = neutrons[i];
        }
        /*
        A deep copy is required for assigning the data from the passed in arry to the array within the internal attributes because just assiging the reference of the passed in array would be unsafe since any changes made to array externally would affect the array internally.
        For the sake of encapsulation and overall data integrity we must create the deep copy. This was done a lot in C++ and I'm sure many other OOP languages since encapsulation is such a huge part of OOP
        */
        
    }
    public String[] getIsotopes(){
        String ret[] = new String[neutrons.length];
        int sum = 0;
        for(int i = 0;i<neutrons.length;i++){
            sum = protons+neutrons[i];
            ret[i] = name+"-"+sum;
        }
        return ret;
    }
    public String getName(){
        return name;
    }
 


    @Override
    public int compareTo(Q2_Element o) {
        if(this.protons == o.protons){
            return 0;
        }else if(this.protons>o.protons){
            return 1;
        }else{
            return -1;
        }
    }
    
}
