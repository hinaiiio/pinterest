import java.util.ArrayList;
import java.util.List;

/**
 * Created by hina on 2017/01/11.
 */
public class GoogleImgList {
    private List<Item> items = new ArrayList<Item>();

    public GoogleImgList() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item{
        private String title;
        private String link;
        private Image image;

        public Item() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }
    }

    public static class Image{
        private String contextLink;
        private int height;
        private int width;
        private String thumbnailLink;

        public Image() {
        }

        public String getContextLink() {
            return contextLink;
        }

        public void setContextLink(String contextlink) {
            this.contextLink = contextlink;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getThumbnailLink() {
            return thumbnailLink;
        }

        public void setThumbnailLink(String thumbnailLink) {
            this.thumbnailLink = thumbnailLink;
        }
    }

}
