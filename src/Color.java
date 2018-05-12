public class Color {
    double red;
    double green;
    double blue;

    public void setColor(int rgb){
        red = (rgb >> 16 ) & 0x000000FF;
        green = (rgb >> 8 ) & 0x000000FF;
        blue = (rgb) & 0x000000FF;
    }

    public Color() {
    }

    public Color(int rgb) {
        setColor(rgb);
    }

    public boolean isBlack(){
        if(red == 0 && green == 0 && blue ==0){
            return true;
        }
        return false;
    }

    public double getPercantageSimilarityToBlack(){
        return 100-(red+green+blue)/(3*255)*100;
    }

   /* public String getColor(){

        return "("+Integer.toString(red)+", "+Integer.toString(green)+", "+Integer.toString(blue)+")";
    } */
}
