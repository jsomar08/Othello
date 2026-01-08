
class Disk {
    private String color;

    @Override
    public String toString() {
        return String.format( "( %s )", color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Disk(String color) {
        this.color = color;
    }

    public Disk flipingPlayer(){
        if(this.color.equals( "•")){
            this.color = "○";
        }
        else if(this.color.equals( "○")){
            this.color = "•";
        }
        return new Disk(color);
    }

    public static void main(String[] args) {
        System.out.println(new Disk("○"));
    }
    





}
