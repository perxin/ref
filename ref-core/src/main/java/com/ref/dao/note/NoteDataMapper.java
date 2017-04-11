package com.ref.dao.note;

import com.ref.model.note.NoteData;

public interface NoteDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteData record);

    int insertSelective(NoteData record);

    NoteData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteData record);

    int updateByPrimaryKeyWithBLOBs(NoteData record);
}