package com.mapper.demo7;

import com.pojo.Account;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    // 获取总记录数
    Long getTotalSize();

    // 使用 limit
    List<Account> findPage(Map<String, Integer> param);
    // 使用 RowBounds
    List<Account> findPage2(RowBounds rowBounds);
}
