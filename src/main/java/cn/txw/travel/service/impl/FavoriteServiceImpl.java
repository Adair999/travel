package cn.txw.travel.service.impl;

import cn.txw.travel.dao.FavoriteDao;
import cn.txw.travel.dao.impl.FavoriteDaoImpl;
import cn.txw.travel.domain.Favorite;
import cn.txw.travel.service.FavoriteService;
/**
 * 线路的收藏
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    /**
     * 判断是否收藏
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public boolean isFavorite(String rid, int uid) {
        Favorite favorite = favoriteDao.findUidByRid(Integer.parseInt(rid), uid);
        return favorite != null; //如何对象有值，则为true，反之，为false
    }
    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    @Override
    public void add(String rid, int uid) {
        favoriteDao.add(Integer.parseInt(rid),uid);
    }
}