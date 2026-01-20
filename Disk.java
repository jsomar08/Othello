
class Disk {
    private String color;

    @Override
    public String toString() {
        return String.format( "( %s )", color);
    }

    /** gets the colour of the disk
     * @return the colour
     */
    public String getColor() {
        return color;
    }

    /** sets the colour of the disk
     * @param color the colour
     */
    public void setColor(String color) {
        this.color = color;
    }

    /** creates disk with the specific colour
     * @param color colour of the disk
     */
    public Disk(String color) {
        this.color = color;
    }

    /** Checks to see if a coordinate on the board is empty
     * @return true or false
     */
    public boolean isEmpty() {
        return color.equals(".");
    }

    /** changes the disk from one colour to the other
     * @return a new Disk with the opposite color of this disk
     */
    public Disk oppositeDisk() {
        String c = "";
        if(this.color.equals( "•")){
            c = "○";
        }
        else if(this.color.equals( "○")){
            c = "•";
        }
        else if(this.color.equals(".")){
            c = ".";
        }
        return new Disk(c);
        
    }
    /** flips the current disks colour and returns a new disk with the opposite colour
     * @return a new Disk after switching this disk's color to the opposite player
     */
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
