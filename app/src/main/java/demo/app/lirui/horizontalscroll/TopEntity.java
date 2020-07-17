package demo.app.lirui.horizontalscroll;

/**
 * @ProjectName: HorizontalScrollDemo-master-master
 * @Package: demo.app.com.horizontalscrolldemo
 * @ClassName: TopEntity
 * @Description:
 * @Author: lirui
 * @CreateDate: 2020/4/23 0023
 */
public class TopEntity {

    private String name;
    private String head;
    private String tag;
    private String post;


    public TopEntity(String name, String head, String tag, String post) {
        this.name = name;
        this.head = head;
        this.tag = tag;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
