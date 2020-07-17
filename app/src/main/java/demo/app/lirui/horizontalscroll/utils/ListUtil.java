package demo.app.lirui.horizontalscroll.utils;

import java.util.ArrayList;

import demo.app.lirui.horizontalscroll.Entity;
import demo.app.lirui.horizontalscroll.TopEntity;

/**
 * @ProjectName: HorizontalScrollDemo-master-master
 * @Package: demo.app.com.horizontalscrolldemo.utils
 * @ClassName: ListUtil
 * @Description:
 * @Author: lirui
 * @CreateDate: 2020/4/23 0023 下午 13:10
 */
public class ListUtil {

    public static ArrayList<Entity> getData() {
        ArrayList<Entity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Entity(getTopData().get(i), getContentData()));
        }
        return list;
    }


    public static ArrayList<TopEntity> getTopData() {
        ArrayList<TopEntity> list = new ArrayList<>();
        list.add(new TopEntity("球员1", "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3445743663,4007175583&fm=26&gp=0.jpg", "马刺", "中锋.#25"));
        list.add(new TopEntity("球员2", "https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=428343399,2788300508&fm=26&gp=0.jpg", "76人", "后卫.#40"));
        list.add(new TopEntity("球员3", "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2271881617,3926986169&fm=26&gp=0.jpg", "快船", "前锋.#50"));
        list.add(new TopEntity("球员4", "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=620449088,2037057570&fm=26&gp=0.jpg", "火箭", "中锋.#30"));
        list.add(new TopEntity("球员5", "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=580181035,930807230&fm=26&gp=0.jpg", "快船", "后卫.#25"));
        list.add(new TopEntity("球员6", "https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2065850969,3084347022&fm=26&gp=0.jpg", "马刺", "中锋.#40"));
        list.add(new TopEntity("球员7", "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3445743663,4007175583&fm=26&gp=0.jpg", "快船", "后卫.#25"));
        list.add(new TopEntity("球员8", "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=580181035,930807230&fm=26&gp=0.jpg", "快船", "中锋.#25"));
        list.add(new TopEntity("球员9", "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2271881617,3926986169&fm=26&gp=0.jpg", "76人", "前锋.#25"));
        list.add(new TopEntity("球员10", "https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=580181035,930807230&fm=26&gp=0.jpg", "马刺", "中锋.#25"));
        return list;
    }


    public static ArrayList<String> getContentData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("40");
        list.add("2.0");
        list.add("0.5");
        list.add("1.2");
        list.add("3.5");
        list.add("4.5");
        list.add("46.7");
        list.add("2.4");
        list.add("5.2");
        list.add("3.0");
        return list;
    }
}
