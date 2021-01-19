package com.nursery.beans;

/**
 * 测试
 */
public class TestDo {

    private String id;
    private String name;

    public TestDo() {
    }

    public TestDo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
