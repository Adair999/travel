package cn.txw.travel.dao;

import cn.txw.travel.domain.Favorite;
/**
 * 线路的收藏
 */
public interface FavoriteDao {
    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findUidByRid(int rid, int uid);
     /**
     * 根据rid查询收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);
    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
     public  void add(int rid, int uid);
}