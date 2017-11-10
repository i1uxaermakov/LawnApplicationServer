package model.services;

public class NewsService {

    private static NewsService newsService = new NewsService();

    public static NewsService getNewsService() {
        return newsService;
    }
}
