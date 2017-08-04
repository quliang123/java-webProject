package cn.ql.spring06Collection;/**
 * Created by 123 on 2017/07/26.
 */

import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/26
 * \* Time: 11:03
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyCollection {
    @Override
    public String toString() {
        return "MyCollection{" +
                "names=" + Arrays.toString(names) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    private String[] names;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties properties;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
