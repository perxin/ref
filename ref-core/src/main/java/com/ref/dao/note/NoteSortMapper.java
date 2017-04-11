package com.ref.dao.note;

import com.ref.model.note.NoteSort;

public interface NoteSortMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteSort record);

    int insertSelective(NoteSort record);

    NoteSort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteSort record);

    int updateByPrimaryKey(NoteSort record);
}