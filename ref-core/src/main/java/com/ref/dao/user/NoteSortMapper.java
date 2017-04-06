package com.ref.dao.user;

import com.ref.model.user.NoteSort;

public interface NoteSortMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteSort record);

    int insertSelective(NoteSort record);

    NoteSort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteSort record);

    int updateByPrimaryKey(NoteSort record);
}