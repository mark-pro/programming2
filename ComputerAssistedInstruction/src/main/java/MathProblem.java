class MathProblem {
    int x;
    int y;

    public MathProblem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getAnswer() { return this.x * this.y; };

    @Override
    public String toString(){
        return String.format("How much is %d times %d: " , this.x, this.y);
    }
}