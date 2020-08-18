package com.gupao.common.netty.io.hashmap;

import lombok.Data;

import java.util.Objects;

/**
 * @Author: GengGhuQiang
 * @Date: 2020/8/14
 */
@Data
public class Study {
    private String name;
    private String money;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Study study = (Study) o;
        return name.equals(study.name) &&
                money.equals(study.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }
}
