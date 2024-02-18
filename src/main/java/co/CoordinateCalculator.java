package co;

public class CoordinateCalculator {
    public static void main(String[] args) {
        int upperLeftX = 1320;
        int upperLeftY = 5850;

        System.out.println("400x150 Horizontal Connector:  "+upperLeftX + ","+upperLeftY+","+(upperLeftX+400)+","+ (upperLeftY+150));

        System.out.println("400x150 Vertical Connector : "+upperLeftX + ","+upperLeftY+","+(upperLeftX+150)+","+ (upperLeftY+400));

        System.out.println("300x100 Horizontal Connector:  "+upperLeftX + ","+upperLeftY+","+(upperLeftX+300)+","+ (upperLeftY+100));

        System.out.println("300x100 Vertical Connector : "+upperLeftX + ","+upperLeftY+","+(upperLeftX+100)+","+ (upperLeftY+300));

        System.out.println("120x120 Square: "+upperLeftX + ","+upperLeftY+","+(upperLeftX+120)+","+ (upperLeftY+120));


        System.out.println("120x100 Horizontal Valve: "+upperLeftX + ","+upperLeftY+","+(upperLeftX+120)+","+ (upperLeftY+100));

        System.out.println("120x100 Vertical Valve: "+upperLeftX + ","+upperLeftY+","+(upperLeftX+100)+","+ (upperLeftY+120));
    }
}
