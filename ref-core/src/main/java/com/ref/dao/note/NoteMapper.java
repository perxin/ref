package com.ref.dao.note;

import com.ref.form.note.NoteAllForm;
import com.ref.form.note.NoteSearchForm;
import com.ref.model.note.Note;

import java.util.List;

public interface NoteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    List<NoteAllForm> selectSelective(NoteSearchForm noteSearchForm);

    List<Note> selectNewDate();

    List<Note> selectHot();
}