package review;

public class Six /*implements Cloneable*/{

    public static void main(String[] args) throws CloneNotSupportedException {
        Six six = new Six();
        Six six2 = (Six) six.clone();//CloneNotSupportedException
    }
}
