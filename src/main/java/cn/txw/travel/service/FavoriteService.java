package cn.txw.travel.service;

/**
 * 线路的收藏
 */
public interface FavoriteService {
    /**
     * 判断是否收藏
     * @param rid
     * @param uid
     * @return
     */
    public boolean isFavorite(String rid,int uid);
    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void add(String rid, int uid);
}