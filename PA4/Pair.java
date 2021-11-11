public class Pair {

    private String loc;
    private int offset;

    public Pair(String loc, int offset) {
        this.loc = loc;
        this.offset = offset;
    }

    public String getLoc() {
        return this.loc;
    }

    public int getOffset() {
        return this.offset;
    }

}

/*
    16-19 --> 
    12-15 --> y -- FP
     8-11 --> RA
     4-7  --> S0
     0-3  --> FP


*/