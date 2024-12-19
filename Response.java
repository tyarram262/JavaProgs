public class Response {
    private MyInt x;
    private int index;

    public Response(MyInt x, int index) {
        if (x != null && index < 0){
            throw new RuntimeException("Invalid search response.");
        }else if(x == null && index != -1){
            throw new RuntimeException("Invalid search response.");
        }
        this.x = x;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Integer " + x.toString() + " found at index " + index;
    }
}