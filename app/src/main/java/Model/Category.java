package Model;

public class Category {
    private String cate,color;
    private int imgCate;


    public Category(String cate, int imgCate) {
        this.cate = cate;
        this.imgCate = imgCate;
    }

    public Category(String cate, String color, int imgCate) {
        this.cate = cate;
        this.color = color;
        this.imgCate = imgCate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public int getImgCate() {
        return imgCate;
    }

    public void setImgCate(int imgCate) {
        this.imgCate = imgCate;
    }
}
