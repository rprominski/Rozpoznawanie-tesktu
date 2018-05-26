public class Color {
    double red;
    double green;
    double blue;

    public void setColor(int rgb){
        red = (rgb >> 16 ) & 0x000000FF;
        green = (rgb >> 8 ) & 0x000000FF;
        blue = (rgb) & 0x000000FF;
    }

    static public int getIntFromColor(int Red, int Green, int Blue){
        Red = (Red << 16) & 0x00FF0000;
        Green = (Green << 8) & 0x0000FF00;
        Blue = Blue & 0x000000FF;

        return 0xFF000000 | Red | Green | Blue;
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
