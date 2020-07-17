package demo.app.lirui.horizontalscroll;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: HorizontalScrollDemo-master-master
 * @Package: demo.app.com.horizontalscrolldemo
 * @ClassName: Entity
 * @Description:
 * @Author: lirui
 * @CreateDate: 2020/4/23 0023
 */
public class Entity {
    private TopEntity topEntity;
    private List<String> rightDatas;


    public Entity(TopEntity topEntity, List<String> rightDatas) {
        this.topEntity = topEntity;
        this.rightDatas = rightDatas;
    }

    public TopEntity getTopEntity() {
        return topEntity;
    }

    public void setTopEntity(TopEntity topEntity) {
        this.topEntity = topEntity;
    }

    public List<String> getRightDatas() {
        if (rightDatas == null) {
            return new ArrayList<>();
        }
        return rightDatas;
    }

    public void setRightDatas(List<String> rightDatas) {
        this.rightDatas = rightDatas;
    }
}
