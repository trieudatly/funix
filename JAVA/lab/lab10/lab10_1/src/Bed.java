public class Bed{
    private String style;
    private int pillows, height, sheets, quilt;


    public Bed(String style, int pillows, int height, int sheets, int quilt){
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quilt = quilt;
        this.style = style;
    }

    public int getPillows(){
        return pillows;
    }

    public int getHeight(){
        return height;
    }

    public int getSheets(){
        return sheets;
    }

    public int getQuilt(){
        return quilt;
    }

    public String getStyle(){
        return style;
    }

    public void make(){
        System.out.println("Making bed");
    }
}
