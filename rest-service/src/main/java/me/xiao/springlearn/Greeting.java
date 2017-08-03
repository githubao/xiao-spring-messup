package me.xiao.springlearn;

/**
 * 实体类
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/3 20:04
 */

public class Greeting {
    private final Long id;
    private final String content;

    public Greeting(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
