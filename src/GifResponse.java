public class GifResponse {
    public Result[] results;

    public class Result {
        public String id;
        public Media[] media;
    }

    public class Media {

        public Gif gif;
        public TinyGif tinygif;
    }

    public class Gif {
        public String url;
    }
    public class TinyGif {
        public String url;
    }
}