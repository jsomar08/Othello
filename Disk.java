
class Disk {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Disk(String color) {
        this.color = color;
    }

    public static String flipingPlayer(String color){
        if(color.equals( "•")){
            color = "○";
        }
        else if(color.equals( "○")){
            color = "•";
        }
        return color;
    }





}
